package ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Vaccination;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;

@Getter
@Setter
@Entity
@Table(name = "individuals_vaccinations")
public class IndividualsVaccination {
    @EmbeddedId
    private IndividualsVaccinationId id;

    @MapsId("individualId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    @MapsId("vaccinationId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "vaccination_id", nullable = false)
    private Vaccination vaccination;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "staff_id")
    private Staff staff;

}