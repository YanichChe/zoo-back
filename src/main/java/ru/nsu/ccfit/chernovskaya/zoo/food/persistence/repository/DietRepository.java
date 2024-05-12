package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.Diet;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DIET, path = ApiPathUtils.DIET)
public interface DietRepository extends PagingAndSortingRepository<Diet, Integer> {
    Diet findById(Integer id);
}