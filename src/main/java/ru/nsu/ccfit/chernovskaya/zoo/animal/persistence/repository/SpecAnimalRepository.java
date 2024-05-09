package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Animal;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.ANIMAL, path = ApiPathUtils.ANIMAL)
public interface SpecAnimalRepository extends PagingAndSortingRepository<Animal, Integer> {
    Animal findById(Integer id);
}
