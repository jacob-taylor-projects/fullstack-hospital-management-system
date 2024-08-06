package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.CompanyDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.FullPatientDto;
import com.project.hospital_Management_System_Backend.services.CompanyService;
import com.project.hospital_Management_System_Backend.services.EmployeeService;
import com.project.hospital_Management_System_Backend.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final EmployeeService employeeService;
    private final PatientService patientService;

    @Override
    public Set<CompanyDto> getAllEmployeesCompanies(CredentialsDto credentialDto) {
        FullEmployeeDto fullEmployeeDto=employeeService.login(credentialDto);
        return fullEmployeeDto.getCompanies();
    }

    @Override
    public Set<CompanyDto> getAllPatientsCompanies(CredentialsDto credentialDto) {
        FullPatientDto fullPatientDto=patientService.login(credentialDto);
        return fullPatientDto.getCompanies();
    }
}
