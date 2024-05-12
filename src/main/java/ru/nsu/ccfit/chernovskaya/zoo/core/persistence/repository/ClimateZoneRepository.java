package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.ClimateZone;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.CLIMATE_ZONE, path = ApiPathUtils.CLIMATE_ZONE)
public interface ClimateZoneRepository extends PagingAndSortingRepository<ClimateZone, Integer> {
    ClimateZone findById(Integer id);
}