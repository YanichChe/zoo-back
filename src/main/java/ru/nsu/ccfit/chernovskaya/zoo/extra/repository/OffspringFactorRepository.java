package ru.nsu.ccfit.chernovskaya.zoo.extra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.extra.entity.OffspringFactor;

public interface OffspringFactorRepository extends JpaRepository<OffspringFactor, Integer> {
}