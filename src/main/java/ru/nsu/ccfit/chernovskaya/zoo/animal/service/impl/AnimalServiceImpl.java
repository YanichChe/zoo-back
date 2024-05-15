package ru.nsu.ccfit.chernovskaya.zoo.animal.service.impl;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualDto;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualRequest;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Animal;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.animal.mapper.AnimalMapper;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository.CustomAnimalRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository.SpecAnimalRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository.SpecIndividualRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.service.AnimalService;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.File;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Gender;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository.FileRepository;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository.GenderRepository;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository.PhysicalStateRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateIndividualSpec;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generatePageable;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateSort;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private static final List<String> availableSortFields = List.of("nameasc", "namedesc");
    private static final String uploadDirectory = "/home/tc/IdeaProjects/zoo/photos/";
    private static final Logger log = LoggerFactory.getLogger(AnimalServiceImpl.class);

    private final AnimalMapper animalMapper;
    private final SpecIndividualRepository individualRepository;
    private final SpecAnimalRepository animalRepository;
    private final CustomAnimalRepository customAnimalRepository;
    private final PhysicalStateRepository physicalStateRepository;
    private final FileRepository fileRepository;
    private final GenderRepository genderRepository;

    @Override
    public @Nullable IndividualDto getIndividualById(int id) {
        Optional<Individual> individual = individualRepository.findById(id);
        return individual.map(animalMapper::map).orElse(null);
    }

    @Override
    public @Nullable List<IndividualDto> getAllIndividuals(Map<String, String> filters, List<String> sorts, int page, int size) {
        var sort = generateSort(sorts, availableSortFields);
        var pageable = generatePageable(page, size, sort);
        var spec = generateIndividualSpec(filters);
        List<Individual> individuals = customAnimalRepository.findAll(spec, pageable, sort);
        return individuals.stream().map(animalMapper::map).collect(Collectors.toList());
    }

    @Override
    public @Nullable List<String> getAllAnimalsTitle() {
        return animalRepository.getAllAnimalTitle();
    }

    @Override
    public int getCount(Map<String, String> filters, List<String> sorts) {
        var sort = generateSort(sorts, availableSortFields);
        var spec = generateIndividualSpec(filters);
        List<Individual> individuals = customAnimalRepository.findAll(spec, null, sort);
        return individuals.size();
    }

    @Override
    public void saveAnimal(@NonNull IndividualRequest animal) throws IOException {
        String filePath = saveImageToStorage(animal.getImage());
        File file = new File();
        file.setPath("photos/" + filePath);
        fileRepository.save(file);

        Individual individual = new Individual();
        individual.setName(animal.getName());
        individual.setDate(animal.getDate());
        individual.setIsAlive(animal.getIsAlive());

        Gender gender = genderRepository.findById(animal.getGender()).orElseThrow(NullPointerException::new);
        individual.setGender(gender);
        individual.setHeight(animal.getHeight());
        individual.setWeight(animal.getWeight());

        log.info(animal.toString());
        Animal animal_ = animalRepository.findByAnimalTitle(animal.getAnimalTitle()).orElseThrow(NullPointerException::new);
        log.info(animal_.toString());

        individual.setAnimal(animal_);
        individual.setPhoto(file);
        individual.setPhysicalState(physicalStateRepository.findById(1).orElseThrow());
        individualRepository.save(individual);
    }

    @Override
    public void deleteAnimal(int id) {
        Individual individual = individualRepository.findById(id).orElseThrow(NullPointerException::new);
        individualRepository.delete(individual);
    }

    @Override
    public void updateAnimal(@NonNull IndividualRequest animal, int id) throws IOException {
        Individual individual = individualRepository.findById(id).orElseThrow(NullPointerException::new);
        individual.setName(animal.getName());
        individual.setDate(animal.getDate());
        individual.setIsAlive(animal.getIsAlive());

        Gender gender = genderRepository.findById(animal.getGender()).orElseThrow(NullPointerException::new);
        individual.setGender(gender);
        individual.setHeight(animal.getHeight());
        individual.setWeight(animal.getWeight());
        individual.setId(id);

        Animal animal_ = animalRepository.findByAnimalTitle(animal.getAnimalTitle()).orElseThrow(NullPointerException::new);

        individual.setAnimal(animal_);
        individual.setPhysicalState(physicalStateRepository.findById(1).orElseThrow());

        if (animal.getImage() != null) {
            log.info("not null");
            String filePath = saveImageToStorage(animal.getImage());
            File file = new File();
            file.setPath("photos/" + filePath);
            fileRepository.save(file);
            individual.setPhoto(file);
        }

        individualRepository.save(individual);
    }

    private String saveImageToStorage(MultipartFile imageFile) throws IOException {
        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        Path uploadPath = Path.of(AnimalServiceImpl.uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        log.info(uploadPath + uniqueFileName);
        return uniqueFileName;
    }
}
