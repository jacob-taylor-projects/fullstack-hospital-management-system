package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.BasicPatientDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullPatientDto;
import com.project.hospital_Management_System_Backend.dtos.PatientRequestDto;

import java.util.Set;

public interface PatientService {
    FullPatientDto login(CredentialsDto credentialDto);

    FullPatientDto createPatient(Long id, PatientRequestDto patientRequestDto);

    Set<FullPatientDto> getPatients(Long id);

    BasicPatientDto updatePatient(Long id, Long patientId, PatientRequestDto patientRequestDto);

    void deletePatient(Long id, Long patientId);
}
