package ru.nsu.ccfit.chernovskaya.zoo.extra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.chernovskaya.zoo.extra.entity.ProhibitedCombinationsSettlement;
import ru.nsu.ccfit.chernovskaya.zoo.extra.entity.ProhibitedCombinationsSettlementId;

public interface ProhibitedCombinationsSettlementRepository extends JpaRepository<ProhibitedCombinationsSettlement, ProhibitedCombinationsSettlementId> {
}