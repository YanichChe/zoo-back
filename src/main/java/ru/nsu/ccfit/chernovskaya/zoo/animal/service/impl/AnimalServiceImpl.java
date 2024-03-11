package ru.nsu.ccfit.chernovskaya.zoo.animal.service.impl;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualDto;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.animal.mapper.AnimalMapper;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository.AnimalRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository.CustomAnimalRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository.IndividualRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.service.AnimalService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateIndividualSpec;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generatePageable;
import static ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortUtil.generateSort;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private static final List<String> availableSortFields = List.of("nameasc", "namedesc");
    private final AnimalMapper animalMapper;
    private final IndividualRepository individualRepository;
    private final AnimalRepository animalRepository;
    private final CustomAnimalRepository customAnimalRepository;

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
}
