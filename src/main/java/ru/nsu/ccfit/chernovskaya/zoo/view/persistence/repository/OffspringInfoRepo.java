package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.OffspringInfo;


@RepositoryRestResource(collectionResourceRel = ApiPathUtils.OffspringInfo, path = ApiPathUtils.OffspringInfo)
public interface OffspringInfoRepo extends PagingAndSortingRepository<OffspringInfo, Integer> {
}