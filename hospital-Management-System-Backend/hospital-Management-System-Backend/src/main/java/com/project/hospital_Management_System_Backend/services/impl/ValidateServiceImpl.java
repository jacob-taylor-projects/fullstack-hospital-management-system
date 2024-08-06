package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import com.project.hospital_Management_System_Backend.exceptions.NotFoundException;
import com.project.hospital_Management_System_Backend.repos.EmployeeRepo;
import com.project.hospital_Management_System_Backend.repos.PatientRepo;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
    private final EmployeeRepo employeeRepo;
    private final PatientRepo patientRepo;
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
}
