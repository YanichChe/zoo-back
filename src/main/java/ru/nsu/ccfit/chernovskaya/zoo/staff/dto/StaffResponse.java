package ru.nsu.ccfit.chernovskaya.zoo.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffResponse implements Serializable {
    private List<StaffDto> staffs;
    private int pages;
}
