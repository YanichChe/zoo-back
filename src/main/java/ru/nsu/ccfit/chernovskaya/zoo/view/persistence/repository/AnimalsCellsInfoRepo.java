package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity.AnimalsCellsInfo;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.AnimalsCells, path = ApiPathUtils.AnimalsCells)
public interface AnimalsCellsInfoRepo extends PagingAndSortingRepository<AnimalsCellsInfo, Integer> {
}