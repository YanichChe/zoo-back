package ru.nsu.ccfit.chernovskaya.zoo.extra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.extra.entity.DiseaseHistory;

public interface DiseaseHistoryRepository extends JpaRepository<DiseaseHistory, Integer> {
}