package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeRequestDto {
    private CredentialsDto credentials;

    private ProfileDto profile;

    private boolean admin;

    private boolean doctor;
}
