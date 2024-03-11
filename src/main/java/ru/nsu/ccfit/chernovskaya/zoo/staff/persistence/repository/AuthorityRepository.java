package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Authority;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.AUTHORITY, path = ApiPathUtils.AUTHORITY)
public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Integer> {
}