package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.AuthorityStaffType;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.AuthorityStaffTypeId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.AUTHORITY_STAFF_TYPE, path = ApiPathUtils.AUTHORITY_STAFF_TYPE)
public interface AuthorityStaffTypeRepository extends PagingAndSortingRepository<AuthorityStaffType, AuthorityStaffTypeId> {
}