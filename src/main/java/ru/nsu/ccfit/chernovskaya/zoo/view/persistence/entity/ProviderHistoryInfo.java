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
        "provider_history.date AS date, " +
        "food_providers.provider AS provider, " +
        "food.food_name AS food_name, " +
        "feed_type.type AS feed_type, " +
        "provider_history.number AS number, " +
        "dimension.dimension AS dimension, " +
        "provider_history.price AS price " +
        "FROM provider_history " +
        "JOIN food_providers ON provider_history.provider_id = food_providers.id " +
        "JOIN food ON provider_history.food_id = food.id " +
        "JOIN dimension ON provider_history.dimension_id = dimension.id " +
        "JOIN feed_type ON food.feed_type_id = feed_type.id")
public class ProviderHistoryInfo {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "provider")
    private String provider;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "feed_type")
    private String feedType;

    @Column(name = "number")
    private int number;

    @Column(name = "dimension")
    private String dimension;

    @Column(name = "price")
    private double price;
}
