package ru.nsu.ccfit.chernovskaya.zoo.staff.service;

import jakarta.annotation.Nullable;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffDto;

import java.util.List;
import java.util.Map;

public interface StaffService {
    @Nullable
    StaffDto getStaffById (int id);
    @Nullable
    List<StaffDto> getAllStaffs(Map<String, String> filters, List<String> sorts, int page, int size);
    int getCount(Map<String, String> filters, List<String> sorts);
}
