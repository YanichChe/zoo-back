package ru.nsu.ccfit.chernovskaya.zoo.animal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class IndividualsVaccinationId implements Serializable {
    private static final long serialVersionUID = -5754243777265582120L;
    @Column(name = "individual_id", nullable = false)
    private Integer individualId;

    @Column(name = "vaccination_id", nullable = false)
    private Integer vaccinationId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IndividualsVaccinationId entity = (IndividualsVaccinationId) o;
        return Objects.equals(this.date, entity.date) &&
                Objects.equals(this.vaccinationId, entity.vaccinationId) &&
                Objects.equals(this.individualId, entity.individualId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, vaccinationId, individualId);
    }

}