package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.VaccinationData;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.VaccinationData, path = ApiPathUtils.VaccinationData)
public interface VaccinationDataRepo extends PagingAndSortingRepository<VaccinationData, Integer> {
}