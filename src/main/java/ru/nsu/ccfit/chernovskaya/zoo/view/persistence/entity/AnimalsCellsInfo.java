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
        "individuals.name AS individual_name, " +
        "animal_title, " +
        "cell_number, " +
        "cell_history.date_start AS cell_date_start, " +
        "cell_history.date_end AS cell_date_end, " +
        "gender.gender AS gender, " +
        "age(individuals.date) AS age, " +
        "individuals.weight, " +
        "individuals.height " +
        "FROM individuals " +
        "JOIN animals ON individuals.animal_id = animals.id " +
        "JOIN cell_history ON individuals.id = cell_history.individual_id " +
        "JOIN gender ON individuals.gender_id = gender.id")
public class AnimalsCellsInfo {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "individual_name")
    private String individualName;

    @Column(name = "animal_title")
    private String animalTitle;

    @Column(name = "cell_number")
    private String cellNumber;

    @Column(name = "cell_date_start")
    private LocalDate cellDateStart;

    @Column(name = "cell_date_end")
    private LocalDate cellDateEnd;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;
}
