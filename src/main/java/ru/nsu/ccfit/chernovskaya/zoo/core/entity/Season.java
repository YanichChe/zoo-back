package ru.nsu.ccfit.chernovskaya.zoo.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.food.entity.DietCharacteristic;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "season")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "season", nullable = false)
    private String season;

    @OneToMany(mappedBy = "season")
    private Set<DietCharacteristic> dietCharacteristics = new LinkedHashSet<>();

}