package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.*;

import java.util.List;
import java.util.Set;

public interface PatientService {
    FullPatientDto login(CredentialsDto credentialDto);

    FullPatientDto createPatient(Long id, PatientRequestDto patientRequestDto);

    Set<FullPatientDto> getPatients(Long id);

    BasicPatientDto updatePatient(Long id, Long patientId, PatientRequestDto patientRequestDto);

    void deletePatient(Long id, Long patientId);

    List<AppointmentsDto> getPatientsAppointments(Long id, Long patientId);

    List<PrescriptionsDto> getPatientsPrescriptions(Long id, Long patientId);

    List<ProceduresDto> getPatientsProcedures(Long id, Long patientId);

    Set<BasicEmployeeDto> getPatientsDoctors(Long id, Long patientId);

    FullPatientDto getPatient(Long id, Long patientId);
}
