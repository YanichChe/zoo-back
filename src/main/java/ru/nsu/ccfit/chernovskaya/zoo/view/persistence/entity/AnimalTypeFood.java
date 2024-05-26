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
        "animals.animal_title AS animal_title, " +
        "food.food_name AS food_name, " +
        "feed_type.type AS feed_type, " +
        "diet_characteristics.age AS age " +
        "FROM diet " +
        "JOIN diet_characteristics ON diet.diet_characteristics_id = diet_characteristics.id " +
        "JOIN animals ON diet_characteristics.animal_id = animals.id " +
        "JOIN season ON diet_characteristics.season_id = season.id " +
        "JOIN food ON diet.food_id = food.id " +
        "JOIN feed_type ON food.feed_type_id = feed_type.id")
public class AnimalTypeFood {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "animal_title")
    private String animalTitle;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "feed_type")
    private String feedType;

    @Column(name = "age")
    private String age;
}
