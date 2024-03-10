package ru.nsu.ccfit.chernovskaya.zoo.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.StaffHistory;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.StaffHistoryId;

public interface StaffHistoryRepository extends JpaRepository<StaffHistory, StaffHistoryId> {
}