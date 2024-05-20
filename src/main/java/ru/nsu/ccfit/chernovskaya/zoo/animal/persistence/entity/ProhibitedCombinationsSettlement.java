package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.rest.core.annotation.RestResource;

@Getter
@Setter
@Entity
@Table(name = "prohibited_combinations_settlement")
public class ProhibitedCombinationsSettlement {
    @EmbeddedId
    private ProhibitedCombinationsSettlementId id;

    @MapsId("animalId1")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id_1", nullable = false)
    @RestResource(path = "animalId1")
    private Animal animalId1;

    @MapsId("animalId2")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id_2", nullable = false)
    @RestResource(path = "animalId2")
    private Animal animalId2;

}