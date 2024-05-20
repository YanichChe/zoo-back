package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.CellHistory;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.CELL_HISTORY, path = ApiPathUtils.CELL_HISTORY)
public interface CellHistoryRepository extends PagingAndSortingRepository<CellHistory, Integer> {
    @RestResource
    Optional<CellHistory> findById(Integer id);

    @RestResource
    void delete(CellHistory cellHistory);

    @RestResource
    CellHistory save(CellHistory cellHistory);
}