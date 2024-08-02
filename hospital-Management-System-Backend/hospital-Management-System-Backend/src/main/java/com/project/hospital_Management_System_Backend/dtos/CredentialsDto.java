package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CredentialsDto {
    private String username;

    private String password;
}
