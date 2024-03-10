package ru.nsu.ccfit.chernovskaya.zoo.extra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.Individual;

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

}