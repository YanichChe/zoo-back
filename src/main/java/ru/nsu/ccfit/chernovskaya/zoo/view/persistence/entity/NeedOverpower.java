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
@Subselect("WITH prohibited AS (SELECT a.id AS a_id, " +
        "                          b.id AS b_id " +
        "                   FROM animals a " +
        "                            CROSS JOIN animals b " +
        "                   WHERE EXISTS(SELECT 1 " +
        "                                FROM prohibited_combinations_settlement " +
        "                                WHERE (animal_id_1 = a.id AND animal_id_2 = b.id) " +
        "                                   OR (animal_id_1 = b.id AND animal_id_2 = a.id))) " +
        "SELECT ROW_NUMBER() OVER () AS row_num, " +
        "       i_1.name AS name_1, " +
        "       a_1.animal_title AS animal_title_1, " +
        "       i_2.name AS name_2, " +
        "       a_2.animal_title AS animal_title_2, " +
        "       a.cell_number AS cell_number_1, " +
        "       b.cell_number AS cell_number_2 " +
        "FROM cell_history a " +
        "         JOIN cell_history b ON a.cell_number = b.cell_number - 1 " +
        "         JOIN individuals i_1 ON a.individual_id = i_1.id " +
        "         JOIN animals a_1 ON i_1.animal_id = a_1.id " +
        "         JOIN individuals i_2 ON b.individual_id = i_2.id " +
        "         JOIN animals a_2 ON i_2.animal_id = a_2.id " +
        "         JOIN prohibited ON prohibited.a_id = a_1.id AND prohibited.b_id = a_2.id " +
        "WHERE a.date_end IS NULL " +
        "  AND b.date_end IS NULL")
public class NeedOverpower {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "name_1")
    private String name1;

    @Column(name = "animal_title_1")
    private String animalTitle1;

    @Column(name = "name_2")
    private String name2;

    @Column(name = "animal_title_2")
    private String animalTitle2;

    @Column(name = "cell_number_1")
    private String cellNumber1;

    @Column(name = "cell_number_2")
    private String cellNumber2;
}
