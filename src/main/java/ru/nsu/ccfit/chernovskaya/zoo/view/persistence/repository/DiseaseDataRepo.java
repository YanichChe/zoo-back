package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.DiseaseData;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DiseaseData, path = ApiPathUtils.DiseaseData)
public interface DiseaseDataRepo extends PagingAndSortingRepository<DiseaseData, Integer> {
}
