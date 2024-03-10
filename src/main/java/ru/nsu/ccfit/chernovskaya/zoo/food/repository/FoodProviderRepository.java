package ru.nsu.ccfit.chernovskaya.zoo.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.food.entity.FoodProvider;

public interface FoodProviderRepository extends JpaRepository<FoodProvider, Integer> {
}