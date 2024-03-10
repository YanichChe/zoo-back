package ru.nsu.ccfit.chernovskaya.zoo.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.IndividualsVaccination;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vaccinations")
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "vaccination_name", nullable = false)
    private String vaccinationName;

    @OneToMany(mappedBy = "vaccination")
    private Set<IndividualsVaccination> individualsVaccinations = new LinkedHashSet<>();

}