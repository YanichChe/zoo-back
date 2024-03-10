package ru.nsu.ccfit.chernovskaya.zoo.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.extra.entity.FamilyRelationship;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "type_relationship")
public class TypeRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "relationship", nullable = false, length = 50)
    private String relationship;

    @OneToMany(mappedBy = "typeRelationship")
    private Set<FamilyRelationship> familyRelationships = new LinkedHashSet<>();

}