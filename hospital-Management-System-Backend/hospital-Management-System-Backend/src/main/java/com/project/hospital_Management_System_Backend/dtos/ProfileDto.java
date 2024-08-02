package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProfileDto {
    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
