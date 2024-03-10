package ru.nsu.ccfit.chernovskaya.zoo.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.AuthorityStaffType;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.AuthorityStaffTypeId;

public interface AuthorityStaffTypeRepository extends JpaRepository<AuthorityStaffType, AuthorityStaffTypeId> {
}