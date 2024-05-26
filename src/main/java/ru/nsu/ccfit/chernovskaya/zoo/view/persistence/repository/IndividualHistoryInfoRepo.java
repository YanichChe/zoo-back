package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.IndividualHistoryInfo;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.IndividualHistoryInfo, path = ApiPathUtils.IndividualHistoryInfo)
public interface IndividualHistoryInfoRepo extends PagingAndSortingRepository<IndividualHistoryInfo, Integer> {
}