package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.INDIVIDUALS, path = ApiPathUtils.INDIVIDUALS)
public interface SpecIndividualRepository extends PagingAndSortingRepository<Individual, Integer> {
    @RestResource(exported = true)
    Optional<Individual> findById(Integer id);

    @RestResource(exported = true)
    Individual save(Individual individual);

    @RestResource(exported = true)
    void delete(Individual individual);
}
