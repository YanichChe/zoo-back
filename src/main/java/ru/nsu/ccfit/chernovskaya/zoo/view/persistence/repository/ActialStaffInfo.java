package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.ActualStaffInfo;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.ACTUAL_STAFF, path = ApiPathUtils.ACTUAL_STAFF)
public interface ActialStaffInfo extends PagingAndSortingRepository<ActualStaffInfo, Integer> {
}