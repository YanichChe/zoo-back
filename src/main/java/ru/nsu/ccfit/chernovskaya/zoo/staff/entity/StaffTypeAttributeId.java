package ru.nsu.ccfit.chernovskaya.zoo.staff.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StaffTypeAttributeId implements Serializable {
    private static final long serialVersionUID = 3280108797448905165L;
    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @Column(name = "staff_type_id", nullable = false)
    private Integer staffTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StaffTypeAttributeId entity = (StaffTypeAttributeId) o;
        return Objects.equals(this.attributeName, entity.attributeName) &&
                Objects.equals(this.staffTypeId, entity.staffTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, staffTypeId);
    }

}