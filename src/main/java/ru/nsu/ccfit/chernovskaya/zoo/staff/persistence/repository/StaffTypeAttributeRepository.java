package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffTypeAttribute;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffTypeAttributeId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.STAFF_TYPE_ATTRIBUTES, path = ApiPathUtils.STAFF_TYPE_ATTRIBUTES)
public interface StaffTypeAttributeRepository extends JpaRepository<StaffTypeAttribute, StaffTypeAttributeId> {
}