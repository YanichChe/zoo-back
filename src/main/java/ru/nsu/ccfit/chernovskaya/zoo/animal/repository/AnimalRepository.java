package ru.nsu.ccfit.chernovskaya.zoo.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}