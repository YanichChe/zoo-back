package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.ProviderHistory;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.PROVIDER_HISTORY, path = ApiPathUtils.PROVIDER_HISTORY)
public interface ProviderHistoryRepository extends PagingAndSortingRepository<ProviderHistory, Integer> {
    @RestResource
    Optional<ProviderHistory> findById(Integer id);

    @RestResource
    void delete(ProviderHistory providerHistory);

    @RestResource
    ProviderHistory save(ProviderHistory providerHistory);
}