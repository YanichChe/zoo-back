package ru.nsu.ccfit.chernovskaya.zoo.animal.service;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualDto;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualRequest;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Animal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AnimalService {
    @Nullable IndividualDto getIndividualById (int id);
    @Nullable List<IndividualDto> getAllIndividuals(Map<String, String> filters, List<String> sorts, int page, int size);
    @Nullable List<String> getAllAnimalsTitle();
    int getCount(Map<String, String> filters, List<String> sorts);
    void saveAnimal(@NonNull IndividualRequest animal) throws IOException;
}
