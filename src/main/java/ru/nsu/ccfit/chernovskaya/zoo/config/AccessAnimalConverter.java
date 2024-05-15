package ru.nsu.ccfit.chernovskaya.zoo.config;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.AccessAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.AccessAnimalId;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class AccessAnimalConverter implements BackendIdConverter {

    @Override
    public boolean supports(Class<?> delimiter) {
        return delimiter.equals(AccessAnimal.class);
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        if (id != null) {
            AccessAnimalId ptid = new AccessAnimalId();
            String[] idParts = id.split("_");
            ptid.setStaffId(Integer.valueOf(idParts[0]));
            ptid.setIndividualId(Integer.valueOf(idParts[1]));
            ptid.setDateStart(LocalDate.parse(idParts[2]));
            return ptid;
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.fromRequestId(id, entityType);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        if (id instanceof AccessAnimalId) {
            AccessAnimalId ptid = (AccessAnimalId) id;
            return String.format("%s_%s_%s", ptid.getStaffId(), ptid.getIndividualId(), ptid.getDateStart());
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(id, entityType);
    }
}
