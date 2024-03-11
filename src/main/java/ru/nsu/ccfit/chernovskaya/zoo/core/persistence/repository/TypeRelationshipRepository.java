package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.TypeRelationship;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.TYPE_RELATIONSHIP, path = ApiPathUtils.TYPE_RELATIONSHIP)
public interface TypeRelationshipRepository extends PagingAndSortingRepository<TypeRelationship, Integer> {
}