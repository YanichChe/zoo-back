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
        "vaccination_id, " +
        "vaccination_name, " +
        "date_appearance, " +
        "date_disappearance, " +
        "COALESCE(children_info.c, 0) AS children_count " +
        "FROM individual_full_info " +
        "JOIN animals ON individual_full_info.animal_id = animals.id " +
        "JOIN gender ON individual_full_info.gender_id = gender.id " +
        "LEFT JOIN individuals_vaccinations ON individual_full_info.id = individuals_vaccinations.individual_id " +
        "JOIN vaccinations ON individuals_vaccinations.vaccination_id = vaccinations.id " +
        "LEFT JOIN (SELECT COUNT(individual_id_1) AS c, individual_id_1 " +
        "           FROM family_relationships " +
        "           WHERE type_relationship_id = 2 OR type_relationship_id = 3 " +
        "           GROUP BY individual_id_1) children_info ON children_info.individual_id_1 = individual_full_info.id")
public class VaccinationData {

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

    @Column(name = "vaccination_id")
    private Long vaccinationId;

    @Column(name = "vaccination_name")
    private String vaccinationName;

    @Column(name = "date_appearance")
    private LocalDate dateAppearance;

    @Column(name = "date_disappearance")
    private LocalDate dateDisappearance;

    @Column(name = "children_count")
    private int childrenCount;
}
