package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.INDIVIDUALS, path = ApiPathUtils.INDIVIDUALS)
public interface SpecIndividualRepository extends PagingAndSortingRepository<Individual, Integer> {
}
