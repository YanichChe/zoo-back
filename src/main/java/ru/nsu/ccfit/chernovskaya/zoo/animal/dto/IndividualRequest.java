package ru.nsu.ccfit.chernovskaya.zoo.animal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndividualRequest {
    private String name;
    private LocalDate date;
    private String animalTitle;
    private Boolean isAlive;
    private int gender;
    private Float height;
    private Float weight;
    @JsonIgnore private MultipartFile image;
}
