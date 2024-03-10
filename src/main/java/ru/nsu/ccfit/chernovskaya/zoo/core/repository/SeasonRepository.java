package ru.nsu.ccfit.chernovskaya.zoo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.core.entity.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
}