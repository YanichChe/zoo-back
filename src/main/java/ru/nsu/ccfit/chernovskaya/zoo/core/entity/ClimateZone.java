package ru.nsu.ccfit.chernovskaya.zoo.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.Animal;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "climate_zones")
public class ClimateZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "is_cold_tolerance", nullable = false)
    private Boolean isColdTolerance = false;

    @Column(name = "climate_zone_name", nullable = false)
    private String climateZoneName;

    @OneToMany(mappedBy = "climateZone")
    private Set<Animal> animals = new LinkedHashSet<>();

}