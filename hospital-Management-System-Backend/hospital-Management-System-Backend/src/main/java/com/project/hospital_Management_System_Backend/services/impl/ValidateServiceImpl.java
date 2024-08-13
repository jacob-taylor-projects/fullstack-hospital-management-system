package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.entities.*;
import com.project.hospital_Management_System_Backend.exceptions.NotFoundException;
import com.project.hospital_Management_System_Backend.repos.*;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
    private final EmployeeRepo employeeRepo;
    private final PatientRepo patientRepo;
    private final CompanyRepo companyRepo;
    private final AnnouncementsRepo announcementsRepo;
    private final PrescriptionsRepo prescriptionsRepo;
    @Override
    public Employee findEmployee(String username) {
        Optional<Employee> employee=employeeRepo.findByCredentialsUsername(username);
        if(employee.isEmpty()){
            throw new NotFoundException("There doesn't appear to be a user with that username");
        }
        return employee.get();
    }

    @Override
    public Patient findPatient(String username) {
        Optional<Patient> patient=patientRepo.findByCredentialsUsername(username);
        if(patient.isEmpty()){
            throw new NotFoundException("There doesn't appear to be a user with that username");
        }
        return patient.get();
    }

    @Override
    public Company findCompany(Long id) {
        Optional<Company> company=companyRepo.findById(id);
        if (company.isEmpty()){
            throw new NotFoundException("There doesnt appear to be a company with that id");
        }
        return company.get();
    }

    @Override
    public Employee findEmployee(Long id) {
        Optional<Employee>employee=employeeRepo.findById(id);
        if (employee.isEmpty()){
            throw new NotFoundException("There does not appear to be an employee with that id");
        }
        return employee.get();
    }

    @Override
    public Announcements findAnnouncement(Long id) {
        Optional<Announcements> announcements=announcementsRepo.findById(id);
        if (announcements.isEmpty()){
            throw new NotFoundException("There doesnt appear to be an announcement with that id");
        }
        return announcements.get();
    }

    @Override
    public Patient findPatient(Long id) {
        Optional<Patient> patient=patientRepo.findById(id);
        if (patient.isEmpty()){
            throw new NotFoundException("There doesnt appear to be a patient with that id");
        }
        return patient.get();
    }

    @Override
    public Prescriptions findPrescription(Long id) {
        Optional<Prescriptions> prescriptions=prescriptionsRepo.findById(id);
        if (prescriptions.isEmpty()){
            throw new NotFoundException("There doesnt appear to be a prescription with that id");
        }
        return prescriptions.get();
    }
}
