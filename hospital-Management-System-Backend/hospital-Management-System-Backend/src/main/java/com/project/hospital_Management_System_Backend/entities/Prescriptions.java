package com.project.hospital_Management_System_Backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Prescriptions {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Employee prescriber;

    @ManyToOne
    private Patient prescribed;
}
