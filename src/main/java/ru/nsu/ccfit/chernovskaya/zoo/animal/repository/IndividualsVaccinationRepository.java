package ru.nsu.ccfit.chernovskaya.zoo.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.IndividualsVaccination;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.IndividualsVaccinationId;

public interface IndividualsVaccinationRepository extends JpaRepository<IndividualsVaccination, IndividualsVaccinationId> {
}