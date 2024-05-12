package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Dimension;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DIMENSION, path = ApiPathUtils.DIMENSION)
public interface DimensionRepository extends PagingAndSortingRepository<Dimension, Integer> {
    Dimension findById(Integer id);
}