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
        "a.animal_title AS a_animal_title, " +
        "b.animal_title AS b_animal_title " +
        "FROM animals a " +
        "CROSS JOIN animals b " +
        "WHERE NOT EXISTS(SELECT 1 " +
        "                 FROM prohibited_combinations_settlement " +
        "                 WHERE (animal_id_1 = a.id AND animal_id_2 = b.id) " +
        "                    OR (animal_id_1 = b.id AND animal_id_2 = a.id))")
public class CompatibleTypes {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "a_animal_title")
    private String aAnimalTitle;

    @Column(name = "b_animal_title")
    private String bAnimalTitle;
}
