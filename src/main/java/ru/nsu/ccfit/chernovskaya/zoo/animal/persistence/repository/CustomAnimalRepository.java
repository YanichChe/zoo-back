package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.util.SpecPageSortRepository;


public interface CustomAnimalRepository extends SpecPageSortRepository<Individual, Long> {}