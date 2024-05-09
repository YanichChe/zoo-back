package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualsVaccination;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualsVaccinationId;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

@RepositoryRestResource(collectionResourceRel = ApiPathUtils.INDIVIDUAL_VACCINATION, path = ApiPathUtils.INDIVIDUAL_VACCINATION)
public interface IndividualsVaccinationRepository extends PagingAndSortingRepository<IndividualsVaccination, IndividualsVaccinationId> {
    IndividualsVaccination findById(IndividualsVaccinationId id);
}