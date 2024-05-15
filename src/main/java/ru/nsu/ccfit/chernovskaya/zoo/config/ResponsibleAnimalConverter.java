package ru.nsu.ccfit.chernovskaya.zoo.config;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualsVaccination;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.ResponsibleAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.ResponsibleAnimalId;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class ResponsibleAnimalConverter implements BackendIdConverter {

    @Override
    public boolean supports(Class<?> delimiter) {
        return delimiter.equals(ResponsibleAnimal.class);
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        if (id != null) {
            ResponsibleAnimalId ptid = new ResponsibleAnimalId();
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
        if (id instanceof ResponsibleAnimalId) {
            ResponsibleAnimalId ptid = (ResponsibleAnimalId) id;
            return String.format("%s_%s_%s", ptid.getStaffId(), ptid.getIndividualId(), ptid.getDateStart());
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(id, entityType);
    }
}
