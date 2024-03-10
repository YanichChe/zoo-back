package ru.nsu.ccfit.chernovskaya.zoo.extra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.extra.entity.CellHistory;

public interface CellHistoryRepository extends JpaRepository<CellHistory, Integer> {
}