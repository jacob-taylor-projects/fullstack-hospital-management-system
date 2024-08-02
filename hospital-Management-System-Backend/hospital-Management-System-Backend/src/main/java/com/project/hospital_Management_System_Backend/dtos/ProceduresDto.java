package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProceduresDto {
    private Long id;

    private String name;

    private String description;

    private BasicEmployeeDto doctor;

    private BasicPatientDto patient;
}
