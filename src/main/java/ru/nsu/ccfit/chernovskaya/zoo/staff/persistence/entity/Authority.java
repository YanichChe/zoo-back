package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "authority", nullable = false, length = 50)
    private String authority;

    @ManyToMany
    @JoinTable(name = "authority_staff_type",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_type_id"))
    private Set<StaffType> staffTypes = new LinkedHashSet<>();

}