package ru.nsu.ccfit.chernovskaya.zoo.staff_animal.entity;

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
public class ResponsibleAnimalId implements Serializable {
    private static final long serialVersionUID = 4710500614072331227L;
    @Column(name = "staff_id", nullable = false)
    private Integer staffId;

    @Column(name = "individual_id", nullable = false)
    private Integer individualId;

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResponsibleAnimalId entity = (ResponsibleAnimalId) o;
        return Objects.equals(this.dateStart, entity.dateStart) &&
                Objects.equals(this.individualId, entity.individualId) &&
                Objects.equals(this.staffId, entity.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, individualId, staffId);
    }

}