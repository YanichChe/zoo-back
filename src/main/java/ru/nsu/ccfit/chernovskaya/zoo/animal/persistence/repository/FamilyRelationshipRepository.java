package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.FamilyRelationship;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.FAMILY_RELATIONSHIP, path = ApiPathUtils.FAMILY_RELATIONSHIP)
public interface FamilyRelationshipRepository extends PagingAndSortingRepository<FamilyRelationship, Integer> {
}