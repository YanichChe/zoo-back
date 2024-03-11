package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.PhysicalState;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.ResponsibleAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Gender;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.File;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.AccessAnimal;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "individuals")
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "is_alive", nullable = false)
    private Boolean isAlive = false;

    @Column(name = "height")
    private Float height;

    @Column(name = "weight")
    private Float weight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "physical_state_id", nullable = false)
    private PhysicalState physicalState;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "photo_id")
    private File photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @OneToMany(mappedBy = "individual")
    private Set<AccessAnimal> accessAnimals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "individual")
    private Set<CellHistory> cellHistories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "individual")
    private Set<DiseaseHistory> diseaseHistories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "individual")
    private Set<IndividualHistory> individualHistories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "individual")
    private Set<IndividualsVaccination> individualsVaccinations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "individual")
    private Set<ResponsibleAnimal> responsibleAnimals = new LinkedHashSet<>();

}