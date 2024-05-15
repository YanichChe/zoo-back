package ru.nsu.ccfit.chernovskaya.zoo.staff_animal.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "access_animals")
public class AccessAnimal {
    @EmbeddedId
    private AccessAnimalId id;

    @MapsId("staffId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @MapsId("individualId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    @Column(name = "date_end")
    private LocalDate dateEnd;

}