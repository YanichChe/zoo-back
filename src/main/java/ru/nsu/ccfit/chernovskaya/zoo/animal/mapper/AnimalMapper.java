package ru.nsu.ccfit.chernovskaya.zoo.animal.mapper;

import org.mapstruct.*;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualDto;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Animal;
import ru.nsu.ccfit.chernovskaya.zoo.animal.persistence.entity.Individual;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Gender;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.File;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AnimalMapper {

    @Mapping(source = "animal", target = "animalAnimalTitle", qualifiedByName = "convertAnimal")
    @Mapping(source = "photo", target = "photoId", qualifiedByName = "convertPhoto")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "convertGender")
    IndividualDto map(Individual individual);

    @Named("convertAnimal")
    static String convertAnimal(Animal animal) {
        return animal.getAnimalTitle();
    }

    @Named("convertPhoto")
    static int convertPhoto(File photo) {
        return photo.getId();
    }

    @Named("convertGender")
    static String convertGender(Gender gender) {
        return gender.getGender();
    }
}
