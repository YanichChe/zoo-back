package ru.nsu.ccfit.chernovskaya.zoo.staff.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "staff_type_attributes")
public class StaffTypeAttribute {
    @EmbeddedId
    private StaffTypeAttributeId id;

    @MapsId("staffTypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "staff_type_id", nullable = false)
    private StaffType staffType;

    @OneToMany(mappedBy = "staffTypeAttribute")
    private Set<StaffAttributesValue> staffAttributesValues = new LinkedHashSet<>();

}