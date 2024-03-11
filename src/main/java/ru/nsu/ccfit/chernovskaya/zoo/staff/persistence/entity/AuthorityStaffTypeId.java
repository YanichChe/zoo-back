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
public class AuthorityStaffTypeId implements Serializable {
    private static final long serialVersionUID = -7590919431275524766L;
    @Column(name = "authority_id", nullable = false)
    private Integer authorityId;

    @Column(name = "staff_type_id", nullable = false)
    private Integer staffTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AuthorityStaffTypeId entity = (AuthorityStaffTypeId) o;
        return Objects.equals(this.authorityId, entity.authorityId) &&
                Objects.equals(this.staffTypeId, entity.staffTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorityId, staffTypeId);
    }

}