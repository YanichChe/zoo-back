package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.DiseaseHistory;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "disease_name", nullable = false)
    private String diseaseName;

    @OneToMany(mappedBy = "disease")
    private Set<DiseaseHistory> diseaseHistories = new LinkedHashSet<>();

}