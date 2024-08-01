package com.project.hospital_Management_System_Backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Data
public class Appointments {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Employee doctor;

    @ManyToOne
    private Patient patient;
}
