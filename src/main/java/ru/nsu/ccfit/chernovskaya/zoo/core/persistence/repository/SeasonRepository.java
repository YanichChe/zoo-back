package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Season;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.SEASON, path = ApiPathUtils.SEASON)
public interface SeasonRepository extends PagingAndSortingRepository<Season, Integer> {
    Season findById(Integer id);
}