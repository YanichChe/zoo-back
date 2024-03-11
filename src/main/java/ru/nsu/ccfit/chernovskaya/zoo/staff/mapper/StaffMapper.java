package ru.nsu.ccfit.chernovskaya.zoo.staff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.File;
import ru.nsu.ccfit.chernovskaya.zoo.core.persistence.entity.Gender;
import ru.nsu.ccfit.chernovskaya.zoo.staff.dto.StaffDto;
import ru.nsu.ccfit.chernovskaya.zoo.staff.persistence.entity.Staff;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StaffMapper {

    @Mapping(source = "photo", target = "photoId", qualifiedByName = "convertPhoto")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "convertGender")
    @Mapping(target = "staffType", ignore = true)
    StaffDto map(Staff staff);

    @Named("convertPhoto")
    static int convertPhoto(File photo) {
        return photo.getId();
    }

    @Named("convertGender")
    static String convertGender(Gender gender) {
        return gender.getGender();
    }
}
