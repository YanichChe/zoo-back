package ru.nsu.ccfit.chernovskaya.zoo.config;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.ProhibitedCombinationsSettlement;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.ProhibitedCombinationsSettlementId;

import java.io.Serializable;

@Component
public class ProhibitedIdConverter implements BackendIdConverter {

    @Override
    public boolean supports(Class<?> delimiter) {
        return delimiter.equals(ProhibitedCombinationsSettlement.class);
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        if (id != null) {
            ProhibitedCombinationsSettlementId ptid = new ProhibitedCombinationsSettlementId();
            String[] idParts = id.split("_");
            ptid.setAnimalId1(Integer.valueOf(idParts[0]));
            ptid.setAnimalId2(Integer.valueOf(idParts[1]));
            return ptid;
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.fromRequestId(id, entityType);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        if (id instanceof ProhibitedCombinationsSettlementId) {
            ProhibitedCombinationsSettlementId ptid = (ProhibitedCombinationsSettlementId) id;
            return String.format("%s_%s", ptid.getAnimalId1(), ptid.getAnimalId2());
        }
        return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(id, entityType);
    }
}
