package ru.nsu.ccfit.chernovskaya.zoo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.core.entity.ClimateZone;

public interface ClimateZoneRepository extends JpaRepository<ClimateZone, Integer> {
}