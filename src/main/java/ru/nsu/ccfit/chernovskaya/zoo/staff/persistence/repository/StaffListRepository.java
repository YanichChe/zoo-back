package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.STAFF_LIST, path = ApiPathUtils.STAFF_LIST)
public interface StaffListRepository extends PagingAndSortingRepository<Staff, Integer> {
    @RestResource(exported = true)
    Optional<Staff> findById(Integer id);

    @RestResource(exported = true)
    void delete(Staff staff);

    @RestResource(exported = true)
    Staff save(Staff staff);
}
