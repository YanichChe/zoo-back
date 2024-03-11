package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity;

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
public class StaffAttributesValueId implements Serializable {
    private static final long serialVersionUID = -7494911660881557874L;
    @Column(name = "staff_id", nullable = false)
    private Integer staffId;

    @Column(name = "staff_type_id", nullable = false)
    private Integer staffTypeId;

    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StaffAttributesValueId entity = (StaffAttributesValueId) o;
        return Objects.equals(this.attributeName, entity.attributeName) &&
                Objects.equals(this.staffTypeId, entity.staffTypeId) &&
                Objects.equals(this.staffId, entity.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeName, staffTypeId, staffId);
    }

}