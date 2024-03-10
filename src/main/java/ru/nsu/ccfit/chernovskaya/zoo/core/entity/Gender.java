package ru.nsu.ccfit.chernovskaya.zoo.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.staff.entity.Staff;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @OneToMany(mappedBy = "gender")
    private Set<Individual> individuals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "gender")
    private Set<Staff> staff = new LinkedHashSet<>();

}