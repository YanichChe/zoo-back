package ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "path", nullable = false)
    private String path;

    @OneToMany(mappedBy = "photo")
    private Set<Individual> individuals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "photo")
    private Set<Staff> staffs = new LinkedHashSet<>();
}