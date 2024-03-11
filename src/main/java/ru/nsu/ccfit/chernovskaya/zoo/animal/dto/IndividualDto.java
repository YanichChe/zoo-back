package ru.nsu.ccfit.chernovskaya.zoo.animal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Individual}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndividualDto implements Serializable {
    private String name;
    private LocalDate date;
    private String animalAnimalTitle;
    private Boolean isAlive;
    private String gender;
    private Float height;
    private Float weight;
    private int photoId;
    private int pages;
}