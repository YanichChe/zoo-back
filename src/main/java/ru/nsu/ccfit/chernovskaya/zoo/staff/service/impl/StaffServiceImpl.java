package ru.nsu.ccfit.chernovskaya.zoo.staff.service.impl;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Animal;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.animal.service.impl.AnimalServiceImpl;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.File;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Gender;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository.FileRepository;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository.GenderRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffDto;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffRequest;
import ru.nsu.ccfit.chernovskaya.zoo.staff.mapper.StaffMapper;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffHistory;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository.CustomStaffRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository.StaffHistoryRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository.StaffRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.service.StaffService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateIndividualSpec;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generatePageable;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateSort;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateStaffSpec;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffServiceImpl implements StaffService {
    private static final String uploadDirectory = "/home/tc/IdeaProjects/zoo/photos/";
    private static final List<String> availableSortFields = List.of("nameasc", "namedesc", "surnameasc", "surnamedesc");
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final CustomStaffRepository customStaffRepository;
    private final FileRepository fileRepository;
    private final GenderRepository genderRepository;

    @Nullable
    @Override
    public StaffDto getStaffById(int id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.map(staffMapper::map).orElse(null);
    }

    @Override
    public List<StaffDto> getAllStaffs(Map<String, String> filters, List<String> sorts, int page, int size) {
        var sort = generateSort(sorts, availableSortFields);
        var pageable = generatePageable(page, size, sort);
        var spec = generateStaffSpec(filters);

        List<Staff> staffs = customStaffRepository.findAll(spec, pageable, sort);
        List<StaffDto> staffDtos = new ArrayList<>();
        for (Staff staff : staffs) {
            StaffDto staffDto = staffMapper.map(staff);
            staffDto.setId(staff.getId());
            staffDto.setStaffType(getLastStaffType(staff));
            staffDtos.add(staffDto);

        }
        return staffDtos;
    }

    private @Nullable String getLastStaffType(Staff staff) {
        Set<StaffHistory> staffHistorySet = staff.getStaffHistories();
        if (!staffHistorySet.isEmpty()) {
            StaffHistory maxStaffHistory = Collections.max(
                    staffHistorySet,
                    Comparator.comparing(StaffHistory::getDateEnd, Comparator.nullsFirst(Comparator.naturalOrder()))
            );
            return maxStaffHistory.getStaffType().getType();
        }
        return null;
    }

    @Override
    public int getCount(Map<String, String> filters, List<String> sorts) {
        var sort = generateSort(sorts, availableSortFields);
        var spec = generateStaffSpec(filters);
        List<Staff> staffs = customStaffRepository.findAll(spec, null, sort);
        return staffs.size();
    }

    @Override
    public void saveStaff(@NonNull StaffRequest staffRequest) throws IOException {
        Staff staff = new Staff();
        if (staffRequest.getImage() != null) {
            String filePath = saveImageToStorage(staffRequest.getImage());
            File file = new File();
            file.setPath("photos/" + filePath);
            fileRepository.save(file);
            staff.setPhoto(file);
        } else {
            File file = fileRepository.findById(4).orElseThrow(NullPointerException::new);
            staff.setPhoto(file);
        }

        staff.setName(staffRequest.getName());
        staff.setSurname(staffRequest.getSurname());
        staff.setMiddleName(staffRequest.getMiddleName());
        staff.setBirthday(staffRequest.getBirthday());

        Gender gender = genderRepository.findById(staffRequest.getGender()).orElseThrow(NullPointerException::new);
        staff.setGender(gender);

        staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(int id) {
        Staff staff = staffRepository.findById(id).orElseThrow(NullPointerException::new);
        staffRepository.delete(staff);
    }

    @Override
    public void updateStaff(@NonNull StaffRequest staffRequest, int id) throws IOException {
        Staff staff = staffRepository.findById(id).orElseThrow(NullPointerException::new);

        if (staffRequest.getImage() != null) {
            String filePath = saveImageToStorage(staffRequest.getImage());
            File file = new File();
            file.setPath("photos/" + filePath);
            fileRepository.save(file);
            staff.setPhoto(file);
        }

        staff.setName(staffRequest.getName());
        staff.setSurname(staffRequest.getSurname());
        staff.setMiddleName(staffRequest.getMiddleName());
        staff.setBirthday(staffRequest.getBirthday());

        Gender gender = genderRepository.findById(staffRequest.getGender()).orElseThrow(NullPointerException::new);
        staff.setGender(gender);

        staffRepository.save(staff);
    }

    private String saveImageToStorage(MultipartFile imageFile) throws IOException {
        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }
}
