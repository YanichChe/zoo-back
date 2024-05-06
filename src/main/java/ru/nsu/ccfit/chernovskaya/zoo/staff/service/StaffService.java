package ru.nsu.ccfit.chernovskaya.zoo.staff.service;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualRequest;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffDto;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface StaffService {
    @Nullable
    StaffDto getStaffById (int id);
    @Nullable
    List<StaffDto> getAllStaffs(Map<String, String> filters, List<String> sorts, int page, int size);
    int getCount(Map<String, String> filters, List<String> sorts);
    void saveStaff(@NonNull StaffRequest staffRequest) throws IOException;
    void deleteStaff(int id);
    void updateStaff(@NonNull StaffRequest staffRequest, int id) throws IOException;
}
