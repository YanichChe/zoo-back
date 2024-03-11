package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;

public interface IndividualRepository extends JpaRepository<Individual, Integer> {
}