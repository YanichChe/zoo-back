package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "individual_receipt_status")
public class IndividualReceiptStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status_name", nullable = false)
    private String statusName;

    @OneToMany(mappedBy = "individualStatus")
    private Set<IndividualHistory> individualHistories = new LinkedHashSet<>();

}