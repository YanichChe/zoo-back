package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.Diet;
import ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity.ProviderHistory;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dimension")
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dimension", nullable = false, length = 50)
    private String dimension;

    @OneToMany(mappedBy = "dimension")
    private Set<Diet> diets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "dimension")
    private Set<ProviderHistory> providerHistories = new LinkedHashSet<>();

}