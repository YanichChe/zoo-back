package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.ProhibitedCombinationsSettlement;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.ProhibitedCombinationsSettlementId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.PROHIBITED_COMBINATION, path = ApiPathUtils.PROHIBITED_COMBINATION)
public interface ProhibitedCombinationsSettlementRepository extends PagingAndSortingRepository<ProhibitedCombinationsSettlement, ProhibitedCombinationsSettlementId> {
    @RestResource
    Optional<ProhibitedCombinationsSettlement> findById(ProhibitedCombinationsSettlementId id);

    @RestResource
    void delete(ProhibitedCombinationsSettlement prohibitedCombinationsSettlement);

    @RestResource
    ProhibitedCombinationsSettlement save(ProhibitedCombinationsSettlement prohibitedCombinationsSettlement);
}