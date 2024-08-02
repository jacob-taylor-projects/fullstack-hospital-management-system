package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class FullEmployeeDto {
    private Long id;

    private ProfileDto profile;

    private int age;

    private String gender;

    private String address;

    private boolean admin;

    private boolean doctor;

    private String specialty;

    private int salary;

    private Set<AnnouncementsDto> announcements;

    private Set<CompanyDto> companies;

    private Set<BasicPatientDto> patients;

    private Set<AppointmentsDto> appointments;

    private Set<PrescriptionsDto> prescriptions;

    private Set<ProceduresDto> procedures;
}
