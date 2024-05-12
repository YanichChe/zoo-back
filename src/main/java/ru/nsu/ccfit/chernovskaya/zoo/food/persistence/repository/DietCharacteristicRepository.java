package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.DietCharacteristic;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.DIET_CHARACTERISTICS, path = ApiPathUtils.DIET_CHARACTERISTICS)
public interface DietCharacteristicRepository extends PagingAndSortingRepository<DietCharacteristic, Integer> {
    DietCharacteristic findById(Integer id);
}