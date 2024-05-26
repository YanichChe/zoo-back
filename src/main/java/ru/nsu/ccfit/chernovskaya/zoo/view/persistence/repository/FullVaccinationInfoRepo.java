package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.FullVaccinationInfo;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.FullVaccinationInfo, path = ApiPathUtils.FullVaccinationInfo)
public interface FullVaccinationInfoRepo extends PagingAndSortingRepository<FullVaccinationInfo, Integer> {
}