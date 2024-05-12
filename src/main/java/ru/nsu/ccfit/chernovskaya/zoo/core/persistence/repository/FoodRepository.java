package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Food;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.FOOD, path = ApiPathUtils.FOOD)
public interface FoodRepository extends PagingAndSortingRepository<Food, Integer> {
    Food findById(Integer id);
}