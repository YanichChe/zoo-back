package ru.nsu.ccfit.chernovskaya.zoo.core.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.chernovskaya.zoo.core.service.FileService;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
@Slf4j
public class FileController {
    private final FileService fileService;

    @CrossOrigin
    @GetMapping(value = "/{id}",  produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getFile(@PathVariable int id) throws MalformedURLException,
            FileNotFoundException {
        Resource resource = fileService.getFileById(id);
        return ResponseEntity.ok()
                .body(resource);
    }
}
