package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualReceiptStatus;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.INDIVIDUAL_RECEIPT_STATUS, path = ApiPathUtils.INDIVIDUAL_RECEIPT_STATUS)
public interface IndividualReceiptStatusRepository extends PagingAndSortingRepository<IndividualReceiptStatus, Integer> {
    IndividualReceiptStatus findById(Integer id);
}