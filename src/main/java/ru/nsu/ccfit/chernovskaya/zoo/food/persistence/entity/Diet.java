package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Dimension;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Food;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "diet")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "diet_characteristics_id")
    private DietCharacteristic dietCharacteristics;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "count", nullable = false)
    private Integer count;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "dimension_id")
    private Dimension dimension;

    @Column(name = "\"time\"", nullable = false)
    private LocalTime time;

}