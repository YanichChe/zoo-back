package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffAttributesValue;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffAttributesValueId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.STAFF_ATTRIBUTES, path = ApiPathUtils.STAFF_ATTRIBUTES)
public interface StaffAttributesValueRepository extends JpaRepository<StaffAttributesValue, StaffAttributesValueId> {
}