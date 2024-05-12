package ru.nsu.ccfit.chernovskaya.zoo.config;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualsVaccination;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualsVaccinationId;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class IndividualVaccinationIdConverter implements BackendIdConverter {

    @Override
    public boolean supports(Class<?> delimiter) {
        return delimiter.equals(IndividualsVaccination.class);
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        if (id != null) {
            IndividualsVaccinationId ptid = new IndividualsVaccinationId();
            String[] idParts = id.split("_");
            ptid.setDate(LocalDate.parse(idParts[2]));
            ptid.setIndividualId(Integer.valueOf(idParts[0]));
            ptid.setVaccinationId(Integer.valueOf(idParts[1]));
            return ptid;
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.fromRequestId(id, entityType);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        if (id instanceof IndividualsVaccinationId) {
            IndividualsVaccinationId ptid = (IndividualsVaccinationId) id;
            return String.format("%s_%s_%s", ptid.getIndividualId(), ptid.getVaccinationId(), ptid.getDate());
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(id, entityType);
    }
}
