package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PatientRequestDto {
    private CredentialsDto credentials;

    private ProfileDto profile;
}
