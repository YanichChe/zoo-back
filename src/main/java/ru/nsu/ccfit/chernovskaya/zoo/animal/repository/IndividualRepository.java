package ru.nsu.ccfit.chernovskaya.zoo.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.Individual;

public interface IndividualRepository extends JpaRepository<Individual, Integer> {
}