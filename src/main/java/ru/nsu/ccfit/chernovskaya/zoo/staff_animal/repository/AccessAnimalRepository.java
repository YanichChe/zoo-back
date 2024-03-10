package ru.nsu.ccfit.chernovskaya.zoo.staff_animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.entity.AccessAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.entity.AccessAnimalId;

public interface AccessAnimalRepository extends JpaRepository<AccessAnimal, AccessAnimalId> {
}