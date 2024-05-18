package ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.AccessAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.AccessAnimalId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.ACCESS_ANIMAL, path = ApiPathUtils.ACCESS_ANIMAL)
public interface AccessAnimalRepository extends PagingAndSortingRepository<AccessAnimal, AccessAnimalId> {
    AccessAnimal findById(AccessAnimalId id);

    @RestResource
    AccessAnimal save(AccessAnimal accessAnimal);

    @RestResource
    void delete(AccessAnimal accessAnimal);
}
