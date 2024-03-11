package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}