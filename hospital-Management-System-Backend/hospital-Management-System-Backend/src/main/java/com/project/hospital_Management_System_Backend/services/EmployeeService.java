package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;

import java.util.Set;

public interface EmployeeService {
    FullEmployeeDto login(CredentialsDto credentialDto);

    FullEmployeeDto createEmployee(Long id, EmployeeRequestDto employeeRequestDto);

    Set<FullEmployeeDto> getEmployees(Long id);

    BasicEmployeeDto updateEmployee(Long id, Long employeeId, EmployeeRequestDto employeeRequestDto);

    void deleteEmployee(Long id, Long employeeId);
}
