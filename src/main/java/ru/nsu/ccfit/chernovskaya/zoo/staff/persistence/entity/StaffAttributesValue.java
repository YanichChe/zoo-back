package ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "staff_attributes_value")
public class StaffAttributesValue {
    @EmbeddedId
    private StaffAttributesValueId id;

    @MapsId("staffId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "staff_type_id", referencedColumnName = "attribute_name", nullable = false),
            @JoinColumn(name = "attribute_name", referencedColumnName = "staff_type_id", nullable = false)
    })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StaffTypeAttribute staffTypeAttributes;

    @Column(name = "attribute_value", nullable = false)
    private String attributeValue;

}