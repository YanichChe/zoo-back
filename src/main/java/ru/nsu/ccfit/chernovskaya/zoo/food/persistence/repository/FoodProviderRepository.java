package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.FoodProvider;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.FOOD_PROVIDERS, path = ApiPathUtils.FOOD_PROVIDERS)
public interface FoodProviderRepository extends PagingAndSortingRepository<FoodProvider, Integer> {
}