package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("select distinct a.animalTitle from Animal a")
    List<String> getAllAnimalTitle();

    Optional<Animal> findByAnimalTitle(String animalTitle);
}