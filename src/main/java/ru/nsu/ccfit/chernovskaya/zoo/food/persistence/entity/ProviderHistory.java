package ru.nsu.ccfit.chernovskaya.zoo.food.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Dimension;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Food;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "provider_history")
public class ProviderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private OffsetDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "provider_id")
    private FoodProvider provider;

    @Column(name = "number")
    private Integer number;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "dimension_id")
    private Dimension dimension;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

}