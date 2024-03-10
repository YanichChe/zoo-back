package ru.nsu.ccfit.chernovskaya.zoo.extra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.extra.entity.FamilyRelationship;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, Integer> {
}