package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.File;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.AccessAnimal;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Gender;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.IndividualsVaccination;
import ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity.ResponsibleAnimal;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "photo_id")
    private File photo;

    @OneToMany(mappedBy = "staff")
    private Set<AccessAnimal> accessAnimals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "staff")
    private Set<IndividualsVaccination> individualsVaccinations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "staff")
    private Set<ResponsibleAnimal> responsibleAnimals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "staff")
    private Set<StaffAttributesValue> staffAttributesValues = new LinkedHashSet<>();

    @OneToMany(mappedBy = "staff")
    private Set<StaffHistory> staffHistories = new LinkedHashSet<>();

}