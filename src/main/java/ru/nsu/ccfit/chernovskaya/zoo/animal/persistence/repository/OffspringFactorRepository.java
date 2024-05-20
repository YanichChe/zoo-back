package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.OffspringFactor;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.OFFSPRING_FACTOR, path = ApiPathUtils.OFFSPRING_FACTOR)
public interface OffspringFactorRepository extends PagingAndSortingRepository<OffspringFactor, Integer> {
    @RestResource
    Optional<OffspringFactor> findById(Integer id);

    @RestResource
    void delete(OffspringFactor  offspringFactor);

    @RestResource
    OffspringFactor save(OffspringFactor offspringFactor);
}