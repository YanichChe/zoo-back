package ru.nsu.ccfit.chernovskaya.zoo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.core.entity.TypeRelationship;

public interface TypeRelationshipRepository extends JpaRepository<TypeRelationship, Integer> {
}