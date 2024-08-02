package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class CompanyDto {
    private Long id;

    private String name;

    private String description;

    private Set<AnnouncementsDto> announcements;

    private Set<BasicEmployeeDto> employees;

    private Set<BasicPatientDto> patients;

    private Set<AppointmentsDto> appointments;

    private Set<PrescriptionsDto> prescriptions;

    private Set<ProceduresDto> procedures;
}
