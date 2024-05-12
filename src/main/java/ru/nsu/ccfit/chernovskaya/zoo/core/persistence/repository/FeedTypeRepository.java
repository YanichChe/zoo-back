package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.FeedType;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.FEED_TYPE, path = ApiPathUtils.FEED_TYPE)
public interface FeedTypeRepository extends PagingAndSortingRepository<FeedType, Integer> {
    FeedType findById(Integer id);
}