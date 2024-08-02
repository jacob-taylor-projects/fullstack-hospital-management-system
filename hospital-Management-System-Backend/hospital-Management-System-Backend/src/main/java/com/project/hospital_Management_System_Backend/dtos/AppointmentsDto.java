package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
public class AppointmentsDto {
    private Long id;

    private String name;

    private String description;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private BasicEmployeeDto doctor;

    private BasicPatientDto patient;
}
