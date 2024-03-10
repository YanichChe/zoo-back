package ru.nsu.ccfit.chernovskaya.zoo.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.IndividualHistory;

public interface IndividualHistoryRepository extends JpaRepository<IndividualHistory, Integer> {
}