package com.project.hospital_Management_System_Backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Announcements> announcements=new HashSet<>();

    @ManyToMany(mappedBy = "companies",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees=new HashSet<>();

    @ManyToMany(mappedBy = "companies",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Patient> patients=new HashSet<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Appointments> appointments=new HashSet<>();

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Prescriptions> prescriptions=new HashSet<>();

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Procedures> procedures=new HashSet<>();
}
