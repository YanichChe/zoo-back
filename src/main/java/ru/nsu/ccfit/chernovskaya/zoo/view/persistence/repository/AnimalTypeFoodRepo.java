package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.AnimalTypeFood;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.ANIMAL_TYPE_FOOD, path = ApiPathUtils.ANIMAL_TYPE_FOOD)
public interface AnimalTypeFoodRepo extends PagingAndSortingRepository<AnimalTypeFood, Integer> {
}
