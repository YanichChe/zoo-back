package ru.nsu.ccfit.chernovskaya.zoo.staff.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffRequest implements Serializable {
    private String name;
    private String surname;
    private String middleName;
    private LocalDate birthday;
    private Integer gender;
    @JsonIgnore
    private MultipartFile image;
}
