package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.DiseaseHistory;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DISEASE_HISTORY, path = ApiPathUtils.DISEASE_HISTORY)
public interface DiseaseHistoryRepository extends PagingAndSortingRepository<DiseaseHistory, Integer> {
    @RestResource
    Optional<DiseaseHistory> findById(Integer id);

    @RestResource
    void delete(DiseaseHistory diseaseHistory);

    @RestResource
    DiseaseHistory save(DiseaseHistory diseaseHistory);
}