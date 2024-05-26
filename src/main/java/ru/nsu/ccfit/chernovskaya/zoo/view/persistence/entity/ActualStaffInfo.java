package ru.nsu.ccfit.chernovskaya.zoo.view.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;


@Entity
@Immutable // Hibernate annotation indicating that the entity is read-only
@Subselect("SELECT ROW_NUMBER() OVER (ORDER BY name, surname, middle_name, date_start) AS row_num, " +
        "name, surname, middle_name, age, gender, date_start, long_work, date_end, type, salary " +
        "FROM (" +
        "  SELECT name, surname, middle_name, AGE(birthday) AS age, gender.gender, date_start, " +
        "         CURRENT_DATE - staff_history.date_start AS long_work, date_end, staff_type.type, salary " +
        "  FROM staff " +
        "  JOIN gender ON staff.gender_id = gender.id " +
        "  JOIN staff_history ON staff.id = staff_history.staff_id " +
        "  JOIN staff_type ON staff_history.staff_type = staff_type.id" +
        ") AS staff_data " +
        "WHERE date_end IS NULL")
@Getter
@Setter
public class ActualStaffInfo {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "age")
    private String age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "long_work")
    private int longWork;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "type")
    private String type;

    @Column(name = "salary")
    private double salary;
}
