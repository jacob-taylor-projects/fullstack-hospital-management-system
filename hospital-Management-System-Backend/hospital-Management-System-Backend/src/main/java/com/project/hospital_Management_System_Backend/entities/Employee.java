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
public class Employee {
    @Id
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

    private boolean admin;

    private boolean doctor;

    private String specialty;

    private int salary;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Announcements> announcements=new HashSet<Announcements>() ;

    @ManyToMany
    @JoinTable(name = "company_employees", joinColumns = @JoinColumn(name = "employee_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "company_id",referencedColumnName = "id"))
    @EqualsAndHashCode.Exclude
    private Set<Company> companies=new HashSet<>();

    @ManyToMany(mappedBy = "employees",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Patient> patients=new HashSet<>();

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Appointments> appointments=new HashSet<>();

    @OneToMany(mappedBy = "prescriber",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Prescriptions> prescriptions=new HashSet<>();

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Procedures> procedures=new HashSet<>();
}
