package ru.nsu.ccfit.chernovskaya.zoo.staff.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffDto;
import ru.nsu.ccfit.chernovskaya.zoo.staff.service.StaffService;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPathUtils.STAFFS, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/count")
    public ResponseEntity<Integer> getAllAnimalsCount(
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(required = false) List<String> sorts) {

        return ResponseEntity.ok(staffService.getCount(filters, sorts));
    }

    @GetMapping(ApiPathUtils.INDIVIDUAL + "/{id}")
    public ResponseEntity<StaffDto> getStaffBtId(@PathVariable int id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaffs(
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) List<String> sorts) {
        return ResponseEntity.ok(staffService.getAllStaffs(filters, sorts, page, size));
    }
}
