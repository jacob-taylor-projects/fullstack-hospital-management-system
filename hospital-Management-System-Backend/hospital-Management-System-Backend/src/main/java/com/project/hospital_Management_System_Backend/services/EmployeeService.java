package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.*;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    FullEmployeeDto login(CredentialsDto credentialDto);

    FullEmployeeDto createEmployee(Long id, EmployeeRequestDto employeeRequestDto);

    Set<FullEmployeeDto> getEmployees(Long id);

    BasicEmployeeDto updateEmployee(Long id, Long employeeId, EmployeeRequestDto employeeRequestDto);

    void deleteEmployee(Long id, Long employeeId);

    Set<BasicPatientDto> getEmployeesPatients(Long id, Long employeeId);

    List<AppointmentsDto> getEmployeesAppointments(Long id, Long employeeId);

    List<PrescriptionsDto> getEmployeesPrescriptions(Long id, Long employeeId);

    List<ProceduresDto> getEmployeesProcedures(Long id, Long employeeId);
}
