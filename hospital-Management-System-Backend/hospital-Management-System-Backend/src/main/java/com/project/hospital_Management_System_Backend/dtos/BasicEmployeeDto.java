package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BasicEmployeeDto {
    private Long id;

    private ProfileDto profile;

    private int age;

    private String gender;

    private String address;

    private boolean admin;

    private boolean doctor;

    private String specialty;

    private int salary;
}
