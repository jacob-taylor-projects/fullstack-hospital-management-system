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
public class Patient {  @Id
@GeneratedValue
private Long id;

    @Embedded
    @Column(nullable = false)
    private Credentials credentials;

    @Embedded
    @Column(nullable = false)
    private Profile profile;

    private int age;

    private String gender;

    private String address;

    private String prognosis;

    @ManyToMany
    @JoinTable(name = "company_patients", joinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "company_id",referencedColumnName = "id"))
    @EqualsAndHashCode.Exclude
    private Set<Company> companies=new HashSet<>();

    @ManyToMany
    @JoinTable(name = "patient_employees", joinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id",referencedColumnName = "id"))
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees=new HashSet<>();

    @OneToMany(mappedBy = "patient")
    @EqualsAndHashCode.Exclude
    private Set<Appointments> appointments=new HashSet<>();

    @OneToMany(mappedBy = "prescribed")
    @EqualsAndHashCode.Exclude
    private Set<Prescriptions> prescriptions=new HashSet<>();

    @OneToMany(mappedBy = "patient")
    @EqualsAndHashCode.Exclude
    private Set<Procedures> procedures=new HashSet<>();
}
