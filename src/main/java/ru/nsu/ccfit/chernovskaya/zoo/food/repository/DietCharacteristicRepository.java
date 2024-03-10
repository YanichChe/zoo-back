package ru.nsu.ccfit.chernovskaya.zoo.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.food.entity.DietCharacteristic;

public interface DietCharacteristicRepository extends JpaRepository<DietCharacteristic, Integer> {
}