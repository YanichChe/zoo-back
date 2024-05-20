package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.FamilyRelationship;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.FAMILY_RELATIONSHIP, path = ApiPathUtils.FAMILY_RELATIONSHIP)
public interface FamilyRelationshipRepository extends PagingAndSortingRepository<FamilyRelationship, Integer> {
    @RestResource
    Optional<FamilyRelationship> findById(Integer id);

    @RestResource
    void delete(FamilyRelationship familyRelationship);

    @RestResource
    FamilyRelationship save(FamilyRelationship familyRelationship);
}