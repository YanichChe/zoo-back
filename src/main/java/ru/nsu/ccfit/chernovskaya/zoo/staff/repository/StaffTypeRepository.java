package ru.nsu.ccfit.chernovskaya.zoo.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.StaffType;

public interface StaffTypeRepository extends JpaRepository<StaffType, Integer> {
}