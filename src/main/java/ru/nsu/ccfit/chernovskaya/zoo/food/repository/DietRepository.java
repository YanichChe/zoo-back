package ru.nsu.ccfit.chernovskaya.zoo.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.food.entity.Diet;

public interface DietRepository extends JpaRepository<Diet, Integer> {
}