package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.CompanyDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;

import java.util.Set;

public interface CompanyService {
    Set<CompanyDto> getAllEmployeesCompanies(CredentialsDto credentialDto);

    Set<CompanyDto> getAllPatientsCompanies(CredentialsDto credentialDto);
}
