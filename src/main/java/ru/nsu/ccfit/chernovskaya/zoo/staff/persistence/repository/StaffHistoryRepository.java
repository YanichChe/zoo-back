package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffHistory;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.StaffHistoryId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.STAFF_HISTORY, path = ApiPathUtils.STAFF_HISTORY)
public interface StaffHistoryRepository extends PagingAndSortingRepository<StaffHistory, StaffHistoryId> {
}