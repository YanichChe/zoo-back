package ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.ResponsibleAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.ResponsibleAnimalId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.RESPONSE_ANIMAL, path = ApiPathUtils.RESPONSE_ANIMAL)
public interface ResponsibleAnimalRepository extends PagingAndSortingRepository<ResponsibleAnimal, ResponsibleAnimalId> {
    ResponsibleAnimal findById(ResponsibleAnimalId id);

    @RestResource
    ResponsibleAnimal save(ResponsibleAnimal responsibleAnimal);

    @RestResource
    void delete(ResponsibleAnimal responsibleAnimal);
}
