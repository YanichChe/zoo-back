package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity;

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
        "age(individual_full_info.birthday) AS age, " +
        "offspring_factors.age_start AS age_start, " +
        "offspring_factors.age_end AS age_end, " +
        "physical_state.state AS state " +
        "FROM individual_full_info " +
        "JOIN animals ON individual_full_info.animal_id = animals.id " +
        "JOIN offspring_factors ON animals.id = offspring_factors.animal_id " +
        "AND individual_full_info.physical_state_id = offspring_factors.physical_state_id " +
        "JOIN physical_state ON individual_full_info.physical_state_id = physical_state.id " +
        "WHERE EXTRACT(YEAR FROM age(individual_full_info.birthday)) <= offspring_factors.age_end")
public class OffspringInfo {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "name")
    private String name;

    @Column(name = "animal_title")
    private String animalTitle;

    @Column(name = "age")
    private String age;

    @Column(name = "age_start")
    private String ageStart;

    @Column(name = "age_end")
    private String ageEnd;

    @Column(name = "state")
    private String state;
}
