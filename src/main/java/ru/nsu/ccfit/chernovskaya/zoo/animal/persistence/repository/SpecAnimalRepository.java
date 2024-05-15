package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Animal;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.ANIMAL, path = ApiPathUtils.ANIMAL)
public interface SpecAnimalRepository extends PagingAndSortingRepository<Animal, Integer> {
    @RestResource(exported = true)
    Optional<Animal> findById(Integer id);

    @RestResource(exported = true)
    void delete(Animal animal);

    @RestResource(exported = true)
    @Query("select distinct a.animalTitle from Animal a")
    List<String> getAllAnimalTitle();

    @RestResource(exported = true)
    Optional<Animal> findByAnimalTitle(String animalTitle);
}
