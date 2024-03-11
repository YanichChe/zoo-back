package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualHistory;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "zoos")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "zoo")
    private Set<IndividualHistory> individualHistories = new LinkedHashSet<>();

}