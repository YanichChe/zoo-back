package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.ProviderHistoryInfo, path = ApiPathUtils.ProviderHistoryInfo)
public interface ProviderHistoryInfo extends PagingAndSortingRepository<ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.ProviderHistoryInfo, Integer> {
}
