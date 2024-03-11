package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "food_providers")
public class FoodProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "provider", nullable = false)
    private String provider;

    @OneToMany(mappedBy = "provider")
    private Set<ProviderHistory> providerHistories = new LinkedHashSet<>();

}