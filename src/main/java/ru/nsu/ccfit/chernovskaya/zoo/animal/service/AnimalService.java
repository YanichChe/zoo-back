package ru.nsu.ccfit.chernovskaya.zoo.animal.service;

import jakarta.annotation.Nullable;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualDto;

import java.util.List;
import java.util.Map;

public interface AnimalService {
    @Nullable IndividualDto getIndividualById (int id);
    @Nullable List<IndividualDto> getAllIndividuals(Map<String, String> filters, List<String> sorts, int page, int size);
    @Nullable List<String> getAllAnimalsTitle();
    int getCount(Map<String, String> filters, List<String> sorts);
}
