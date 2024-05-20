package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.Diet;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DIET, path = ApiPathUtils.DIET)
public interface DietRepository extends PagingAndSortingRepository<Diet, Integer> {
    @RestResource
    Optional<Diet> findById(Integer id);

    @RestResource
    void delete(Diet diet);

    @RestResource
    Diet save(Diet diet);
}
