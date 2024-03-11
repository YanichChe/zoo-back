package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.DietCharacteristic;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.OffspringFactor;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "physical_state")
public class PhysicalState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "state", nullable = false)
    private String state;

    @OneToMany(mappedBy = "physicalState")
    private Set<DietCharacteristic> dietCharacteristics = new LinkedHashSet<>();

    @OneToMany(mappedBy = "physicalState")
    private Set<Individual> individuals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "physicalState")
    private Set<OffspringFactor> offspringFactors = new LinkedHashSet<>();

}