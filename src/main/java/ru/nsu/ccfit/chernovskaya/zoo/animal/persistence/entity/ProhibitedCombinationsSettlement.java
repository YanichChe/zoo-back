package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private Animal animalId1;

    @MapsId("animalId2")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id_2", nullable = false)
    private Animal animalId2;

}