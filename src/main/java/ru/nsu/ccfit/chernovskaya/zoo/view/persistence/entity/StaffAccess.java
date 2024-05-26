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
        "staff_id, staff_name, staff_surname, middle_name, " +
        "individual_id, individual_name, animal_id " +
        "FROM staff_access")
public class StaffAccess {

    @Id
    @Column(name = "row_num")
    private Long rowNum;

    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_surname")
    private String staffSurname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "individual_id")
    private Long individualId;

    @Column(name = "individual_name")
    private String individualName;

    @Column(name = "animal_id")
    private Long animalId;
}