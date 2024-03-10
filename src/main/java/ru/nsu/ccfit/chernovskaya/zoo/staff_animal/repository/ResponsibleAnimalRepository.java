package ru.nsu.ccfit.chernovskaya.zoo.staff_animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.entity.ResponsibleAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.entity.ResponsibleAnimalId;

public interface ResponsibleAnimalRepository extends JpaRepository<ResponsibleAnimal, ResponsibleAnimalId> {
}