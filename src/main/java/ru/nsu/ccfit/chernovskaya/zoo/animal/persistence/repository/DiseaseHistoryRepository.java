package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.DiseaseHistory;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DISEASE_HISTORY, path = ApiPathUtils.DISEASE_HISTORY)
public interface DiseaseHistoryRepository extends PagingAndSortingRepository<DiseaseHistory, Integer> {
    DiseaseHistory findById(Integer id);
}