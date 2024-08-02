package com.project.hospital_Management_System_Backend.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class AnnouncementsDto {
    private Long id;

    private Timestamp date;

    private String title;

    private String message;

    private BasicEmployeeDto author;
}