package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.TypeRelationship;

@Getter
@Setter
@Entity
@Table(name = "family_relationships")
public class FamilyRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "individual_id_1")
    private Individual individualId1;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "individual_id_2")
    private Individual individualId2;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "type_relationship_id")
    private TypeRelationship typeRelationship;

}