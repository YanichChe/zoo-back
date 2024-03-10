package ru.nsu.ccfit.chernovskaya.zoo.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.StaffTypeAttribute;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.StaffTypeAttributeId;

public interface StaffTypeAttributeRepository extends JpaRepository<StaffTypeAttribute, StaffTypeAttributeId> {
}