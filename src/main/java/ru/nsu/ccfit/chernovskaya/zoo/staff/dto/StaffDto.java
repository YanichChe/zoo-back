package ru.nsu.ccfit.chernovskaya.zoo.staff.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Staff}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffDto implements Serializable {
    private String name;
    private String surname;
    private String middleName;
    private LocalDate birthday;
    private String gender;
    private Integer photoId;
    private String staffType;
}