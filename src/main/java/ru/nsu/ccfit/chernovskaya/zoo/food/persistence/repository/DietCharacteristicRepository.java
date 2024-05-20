package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.DietCharacteristic;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DIET_CHARACTERISTICS, path = ApiPathUtils.DIET_CHARACTERISTICS)
public interface DietCharacteristicRepository extends PagingAndSortingRepository<DietCharacteristic, Integer> {
    @RestResource
    Optional<DietCharacteristic> findById(Integer id);

    @RestResource
    void delete(DietCharacteristic dietCharacteristic);

    @RestResource
    DietCharacteristic save(DietCharacteristic dietCharacteristic);
}