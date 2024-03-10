package ru.nsu.ccfit.chernovskaya.zoo.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.StaffAttributesValue;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.StaffAttributesValueId;

public interface StaffAttributesValueRepository extends JpaRepository<StaffAttributesValue, StaffAttributesValueId> {
}