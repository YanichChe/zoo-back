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
        "individual_full_info.name AS individual_name, " +
        "animal_title, " +
        "gender.gender AS gender, " +
        "age(individual_full_info.birthday) AS age, " +
        "disease_name, " +
        "date_appearance, " +
        "date_disappearance, " +
        "disease_history.date_start AS disease_history_date_start, " +
        "disease_history.date_end AS disease_history_date_end, " +
        "COALESCE(children_info.c, 0) AS children_count " +
        "FROM individual_full_info " +
        "JOIN animals ON individual_full_info.animal_id = animals.id " +
        "JOIN gender ON individual_full_info.gender_id = gender.id " +
        "JOIN disease_history ON disease_history.individual_id = individual_full_info.id " +
        "JOIN disease ON disease_history.disease_id = disease.id " +
        "LEFT JOIN (SELECT COUNT(individual_id_1) AS c, individual_id_1 " +
        "           FROM family_relationships " +
        "           WHERE type_relationship_id = 2 OR type_relationship_id = 3 " +
        "           GROUP BY individual_id_1) children_info ON children_info.individual_id_1 = individual_full_info.id")
public class DiseaseData {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "individual_name")
    private String individualName;

    @Column(name = "animal_title")
    private String animalTitle;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Column(name = "disease_name")
    private String diseaseName;

    @Column(name = "date_appearance")
    private LocalDate dateAppearance;

    @Column(name = "date_disappearance")
    private LocalDate dateDisappearance;

    @Column(name = "disease_history_date_start")
    private LocalDate diseaseHistoryDateStart;

    @Column(name = "disease_history_date_end")
    private LocalDate diseaseHistoryDateEnd;

    @Column(name = "children_count")
    private int childrenCount;
}
