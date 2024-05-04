package ru.nsu.ccfit.chernovskaya.zoo.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.support.RequestContextUtils;
import ru.nsu.ccfit.chernovskaya.zoo.exception.dto.ErrorDto;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNSUPPORTED_MEDIA_TYPE;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionCatcher {

    private final MessageSource messageSource;

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDto> handleDataIntegrityViolationException(HttpServletRequest request, DataIntegrityViolationException e) {

        if (!(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException)) {
            return handleException(request);
        }

        log.error(e.getMessage());
        var sql = ((org.hibernate.exception.ConstraintViolationException) e.getCause()).getSQL();

        return ResponseEntity.status(BAD_REQUEST)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage(getMessageCodeBySql(sql), request))
                                .build());
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorDto> handleDataAccessException(HttpServletRequest request, DataAccessException e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.database-access-error", request))
                                .build());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolationException(
            HttpServletRequest request, ConstraintViolationException e) {
        var errors =
                e.getConstraintViolations().stream()
                        .map(
                                constraintViolation ->
                                        new FieldError(
                                                constraintViolation.getRootBeanClass().getName(),
                                                constraintViolation.getPropertyPath().toString(),
                                                constraintViolation.getMessage()))
                        .collect(
                                Collectors.groupingBy(
                                        FieldError::getField,
                                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.joining(" "))));

        return ResponseEntity.status(BAD_REQUEST)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.validation-error", request))
                                .errors(errors)
                                .build());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDto> handleNoHandlerFoundException(HttpServletRequest request) {
        return ResponseEntity.status(NOT_FOUND)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.endpoint-not-found", request))
                                .build());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDto> handleHttpRequestMethodNotSupportedException(
            HttpServletRequest request) {
        return ResponseEntity.status(METHOD_NOT_ALLOWED)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.method-not-supported", request))
                                .build());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> handleHttpMessageNotReadableException(
            HttpServletRequest request) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.invalid-json-format", request))
                                .build());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDto> handleMissingServletRequestParameterException(
            HttpServletRequest request) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.missing-request-parameter", request))
                                .build());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorDto> handleHttpMediaTypeNotSupportedException(
            HttpServletRequest request) {
        return ResponseEntity.status(UNSUPPORTED_MEDIA_TYPE)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.unsupported-media-type", request))
                                .build());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(HttpServletRequest request) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.internal-server-error", request))
                                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException e) {
        var errors =
                e.getBindingResult().getFieldErrors().stream()
                        .collect(
                                Collectors.groupingBy(
                                        FieldError::getField,
                                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.joining(" "))));

        return ResponseEntity.status(BAD_REQUEST)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.validation-error", request))
                                .errors(errors)
                                .build());
    }

    private HttpStatus getErrorTypeBySql(String sql) {
        if (StringUtils.startsWithAny(sql.toLowerCase(), "insert", "update", "delete", "select")) {
            return BAD_REQUEST;
        }
        return INTERNAL_SERVER_ERROR;
    }

    private String getMessageCodeBySql(String sql) {
        if (sql.toLowerCase().startsWith("insert")) return "exception.data-integrity-violation.insert";
        if (sql.toLowerCase().startsWith("update")) return "exception.data-integrity-violation.update";
        if (sql.toLowerCase().startsWith("delete")) return "exception.data-integrity-violation.delete";
        if (sql.toLowerCase().startsWith("select")) return "exception.data-integrity-violation.select";
        return "exception.internal-server-error";
    }

    private String getMessage(String code, HttpServletRequest request) {
        return messageSource.getMessage(code, null, RequestContextUtils.getLocale(request));
    }
}
