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
        "individual_full_info.name AS individual_name, " +
        "animal_title, " +
        "age(individual_full_info.birthday) AS age " +
        "FROM individual_full_info " +
        "JOIN animals ON individual_full_info.animal_id = animals.id " +
        "LEFT JOIN climate_zones ON animals.climate_zone_id = climate_zones.id " +
        "WHERE individual_full_info.date_disappearance IS NULL " +
        "AND individual_full_info.is_alive = true " +
        "AND is_cold_tolerance = true")
public class NeedWarmRoom {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "individual_name")
    private String individualName;

    @Column(name = "animal_title")
    private String animalTitle;

    @Column(name = "age")
    private String age;
}
