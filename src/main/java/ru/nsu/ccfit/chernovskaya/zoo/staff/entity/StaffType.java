package ru.nsu.ccfit.chernovskaya.zoo.staff.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "staff_type")
public class StaffType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @ManyToMany(mappedBy = "staffTypes")
    private Set<Authority> authorities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "staffType")
    private Set<StaffHistory> staffHistories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "staffType")
    private Set<StaffTypeAttribute> staffTypeAttributes = new LinkedHashSet<>();

}