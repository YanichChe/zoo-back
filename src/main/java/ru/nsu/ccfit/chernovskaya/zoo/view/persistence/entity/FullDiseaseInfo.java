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
        "disease.disease_name AS disease_name, " +
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
        "JOIN disease_history ON disease_history.individual_id = individual_full_info.id " +
        "JOIN disease ON disease_history.disease_id = disease.id")
public class FullDiseaseInfo {

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

    @Column(name = "disease_name")
    private String diseaseName;

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
