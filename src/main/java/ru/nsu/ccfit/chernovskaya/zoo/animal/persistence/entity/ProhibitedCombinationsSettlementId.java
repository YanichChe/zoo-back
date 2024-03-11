package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProhibitedCombinationsSettlementId implements Serializable {
    private static final long serialVersionUID = -3631241469732799115L;
    @Column(name = "animal_id_1", nullable = false)
    private Integer animalId1;

    @Column(name = "animal_id_2", nullable = false)
    private Integer animalId2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProhibitedCombinationsSettlementId entity = (ProhibitedCombinationsSettlementId) o;
        return Objects.equals(this.animalId1, entity.animalId1) &&
                Objects.equals(this.animalId2, entity.animalId2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId1, animalId2);
    }

}