package ru.nsu.ccfit.chernovskaya.zoo.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.food.entity.Diet;
import ru.nsu.ccfit.chernovskaya.zoo.food.entity.ProviderHistory;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "feed_type_id")
    private FeedType feedType;

    @Column(name = "self_sufficiency")
    private Boolean selfSufficiency;

    @OneToMany(mappedBy = "food")
    private Set<Diet> diets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<ProviderHistory> providerHistories = new LinkedHashSet<>();

}