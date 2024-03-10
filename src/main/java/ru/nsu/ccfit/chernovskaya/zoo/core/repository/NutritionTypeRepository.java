package ru.nsu.ccfit.chernovskaya.zoo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.core.entity.NutritionType;

public interface NutritionTypeRepository extends JpaRepository<NutritionType, Integer> {
}