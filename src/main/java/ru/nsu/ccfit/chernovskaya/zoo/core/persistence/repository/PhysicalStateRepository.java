package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.PhysicalState;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.PHYSICAL_STATE, path = ApiPathUtils.PHYSICAL_STATE)
public interface PhysicalStateRepository extends PagingAndSortingRepository<PhysicalState, Integer> {
    Optional<PhysicalState> findById(Integer id);
}