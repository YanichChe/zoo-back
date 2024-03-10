package ru.nsu.ccfit.chernovskaya.zoo.extra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.Animal;

@Getter
@Setter
@Entity
@Table(name = "prohibited_combinations_settlement")
public class ProhibitedCombinationsSettlement {
    @EmbeddedId
    private ProhibitedCombinationsSettlementId id;

    @MapsId("animalId1")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id_1", nullable = false)
    private Animal animalId1;

    @MapsId("animalId2")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id_2", nullable = false)
    private Animal animalId2;

}