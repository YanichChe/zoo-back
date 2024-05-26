package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;


@Entity
@Immutable
@Getter
@Setter
@Subselect("SELECT ROW_NUMBER() OVER () AS row_num, " +
        "individual_history.receipt_date AS receipt_date, " +
        "zoos.name AS zoo_name, " +
        "individual_receipt_status.status_name AS status_name " +
        "FROM individual_history " +
        "JOIN individuals ON individual_history.individual_id = individuals.id " +
        "JOIN zoos ON individual_history.zoo_id = zoos.id " +
        "JOIN individual_receipt_status ON individual_history.individual_status = individual_receipt_status.id")
public class IndividualHistoryInfo {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "receipt_date")
    private LocalDate receiptDate;

    @Column(name = "zoo_name")
    private String zooName;

    @Column(name = "status_name")
    private String statusName;
}
