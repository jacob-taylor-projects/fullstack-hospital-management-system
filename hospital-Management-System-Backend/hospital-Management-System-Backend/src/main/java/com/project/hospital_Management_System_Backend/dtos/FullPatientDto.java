package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class FullPatientDto {
    private Long id;

    private ProfileDto profile;

    private int age;

    private String gender;

    private String address;

    private String prognosis;

    private Set<CompanyDto> companies;

    private Set<BasicEmployeeDto> employees;

    private Set<AppointmentsDto> appointments;

    private Set<PrescriptionsDto> prescriptions;

    private Set<ProceduresDto> procedures;
}
