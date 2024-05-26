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
        "individual_full_info.name AS name, " +
        "animals.animal_title AS animal_title, " +
        "individual_full_info.height AS height, " +
        "individual_full_info.weight AS weight, " +
        "vaccinations.vaccination_name AS vaccination_name, " +
        "individual_full_info.birthday AS birthday, " +
        "individual_full_info.date_appearance AS date_appearance, " +
        "individual_full_info.date_disappearance AS date_disappearance, " +
        "age(individual_full_info.birthday) AS age, " +
        "(SELECT cell_number " +
        " FROM cell_history " +
        " WHERE individual_id = individual_full_info.id " +
        " ORDER BY date_end DESC " +
        " LIMIT 1) AS cell_number " +
        "FROM individual_full_info " +
        "JOIN animals ON individual_full_info.animal_id = animals.id " +
        "JOIN individuals_vaccinations ON individual_full_info.id = individuals_vaccinations.individual_id " +
        "JOIN vaccinations ON individuals_vaccinations.vaccination_id = vaccinations.id")
public class FullVaccinationInfo {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "name")
    private String name;

    @Column(name = "animal_title")
    private String animalTitle;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "vaccination_name")
    private String vaccinationName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "date_appearance")
    private LocalDate dateAppearance;

    @Column(name = "date_disappearance")
    private LocalDate dateDisappearance;

    @Column(name = "age")
    private String age;

    @Column(name = "cell_number")
    private String cellNumber;
}