package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.ProviderHistory;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.PROVIDER_HISTORY, path = ApiPathUtils.PROVIDER_HISTORY)
public interface ProviderHistoryRepository extends PagingAndSortingRepository<ProviderHistory, Integer> {
    ProviderHistory findById(Integer id);
}