package ru.nsu.ccfit.chernovskaya.zoo.food.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.animal.entity.Animal;
import ru.nsu.ccfit.chernovskaya.zoo.core.entity.PhysicalState;
import ru.nsu.ccfit.chernovskaya.zoo.core.entity.Season;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "diet_characteristics")
public class DietCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "age", nullable = false)
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "physical_state_id")
    private PhysicalState physicalState;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @OneToMany(mappedBy = "dietCharacteristics")
    private Set<Diet> diets = new LinkedHashSet<>();

}