package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.ClimateZone;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.NutritionType;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.DietCharacteristic;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "animal_title", nullable = false)
    private String animalTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "climate_zone_id")
    private ClimateZone climateZone;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "nutrition_type_id")
    private NutritionType nutritionType;

    @OneToMany(mappedBy = "animal")
    private Set<DietCharacteristic> dietCharacteristics = new LinkedHashSet<>();

    @OneToMany(mappedBy = "animal")
    private Set<Individual> individuals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "animal")
    private Set<OffspringFactor> offspringFactors = new LinkedHashSet<>();

}