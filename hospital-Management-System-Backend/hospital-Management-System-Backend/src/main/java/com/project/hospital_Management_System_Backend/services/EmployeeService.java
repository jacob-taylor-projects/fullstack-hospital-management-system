package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;

public interface EmployeeService {
    FullEmployeeDto login(CredentialsDto credentialDto);
}
