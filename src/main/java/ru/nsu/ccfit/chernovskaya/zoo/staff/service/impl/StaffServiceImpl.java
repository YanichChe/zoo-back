package ru.nsu.ccfit.chernovskaya.zoo.staff.service.impl;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffDto;
import ru.nsu.ccfit.chernovskaya.zoo.staff.mapper.StaffMapper;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffHistory;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository.CustomStaffRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository.StaffRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.service.StaffService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateIndividualSpec;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generatePageable;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateSort;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateStaffSpec;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private static final List<String> availableSortFields = List.of("nameasc", "namedesc", "surnameasc", "surnamedesc");
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final CustomStaffRepository customStaffRepository;

    @Nullable
    @Override
    public StaffDto getStaffById(int id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.map(staffMapper::map).orElse(null);
    }

    @Nullable
    @Override
    public List<StaffDto> getAllStaffs(Map<String, String> filters, List<String> sorts, int page, int size) {
        var sort = generateSort(sorts, availableSortFields);
        var pageable = generatePageable(page, size, sort);
        var spec = generateStaffSpec(filters);

        List<Staff> staffs = customStaffRepository.findAll(spec, pageable, sort);
        List<StaffDto> staffDtos = new ArrayList<>();
        for (Staff staff : staffs) {
            StaffDto staffDto = staffMapper.map(staff);
            staffDto.setStaffType(getLastStaffType(staff));
            staffDtos.add(staffDto);

        }
        return staffDtos;
    }

    private @NonNull String getLastStaffType(Staff staff) {
        Set<StaffHistory> staffHistorySet = staff.getStaffHistories();
        StaffHistory maxStaffHistory = Collections.max(
                staffHistorySet,
                Comparator.comparing(StaffHistory::getDateEnd, Comparator.nullsFirst(Comparator.naturalOrder()))
        );
        return maxStaffHistory.getStaffType().getType();
    }

    @Override
    public int getCount(Map<String, String> filters, List<String> sorts) {
        var sort = generateSort(sorts, availableSortFields);
        var spec = generateStaffSpec(filters);
        List<Staff> staffs = customStaffRepository.findAll(spec, null, sort);
        return staffs.size();
    }
}
