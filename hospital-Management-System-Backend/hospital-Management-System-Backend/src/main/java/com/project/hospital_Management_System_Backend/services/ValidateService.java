package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;

public interface ValidateService {
    Employee findEmployee(String username);

    Patient findPatient(String username);
}
