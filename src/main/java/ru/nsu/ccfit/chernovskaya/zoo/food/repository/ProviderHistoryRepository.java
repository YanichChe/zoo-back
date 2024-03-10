package ru.nsu.ccfit.chernovskaya.zoo.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.food.entity.ProviderHistory;

public interface ProviderHistoryRepository extends JpaRepository<ProviderHistory, Integer> {
}