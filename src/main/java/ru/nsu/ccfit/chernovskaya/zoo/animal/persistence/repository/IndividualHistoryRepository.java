package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualHistory;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.INDIVIDUAL_HISTORY, path = ApiPathUtils.INDIVIDUAL_HISTORY)
public interface IndividualHistoryRepository extends PagingAndSortingRepository<IndividualHistory, Integer> {
    @RestResource
    Optional<IndividualHistory> findById(Integer id);

    @RestResource
    void delete(IndividualHistory individualHistory);

    @RestResource
    IndividualHistory save(IndividualHistory individualHistory);
}
