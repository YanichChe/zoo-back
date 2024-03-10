package ru.nsu.ccfit.chernovskaya.zoo.staff.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "authority_staff_type")
public class AuthorityStaffType {
    @EmbeddedId
    private AuthorityStaffTypeId id;

    @MapsId("authorityId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "authority_id", nullable = false)
    private Authority authority;

    @MapsId("staffTypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "staff_type_id", nullable = false)
    private StaffType staffType;

}