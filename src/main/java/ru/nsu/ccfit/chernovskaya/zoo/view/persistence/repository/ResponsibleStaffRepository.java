package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.ResponsibleStaff;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.RESPONSIBLE_ANIMALS, path = ApiPathUtils.RESPONSIBLE_ANIMALS)
public interface ResponsibleStaffRepository extends PagingAndSortingRepository<ResponsibleStaff, Integer> {
}
