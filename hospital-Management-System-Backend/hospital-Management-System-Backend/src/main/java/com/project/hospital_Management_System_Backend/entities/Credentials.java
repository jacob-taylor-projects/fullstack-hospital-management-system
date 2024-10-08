package com.project.hospital_Management_System_Backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Credentials {
    @Column(nullable = false)
    private String username;

    private String password;
}
