package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullPatientDto;
import com.project.hospital_Management_System_Backend.entities.Credentials;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import com.project.hospital_Management_System_Backend.exceptions.BadRequestException;
import com.project.hospital_Management_System_Backend.exceptions.NotAuthorizedException;
import com.project.hospital_Management_System_Backend.mappers.CredentialsMapper;
import com.project.hospital_Management_System_Backend.mappers.FullPatientMapper;
import com.project.hospital_Management_System_Backend.repos.PatientRepo;
import com.project.hospital_Management_System_Backend.services.PatientService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final CredentialsMapper credentialsMapper;
    private final ValidateService validateService;
    private final PatientRepo patientRepo;
    private final FullPatientMapper fullPatientMapper;
    @Override
    public FullPatientDto login(CredentialsDto credentialsDto) {
        if(credentialsDto==null||credentialsDto.getUsername()==null||credentialsDto.getPassword()==null){
            throw new BadRequestException("A username and password are needed");
        }
        Credentials credentialsToValidate=credentialsMapper.dtoToEntity(credentialsDto);
        Patient patientToValidate=validateService.findPatient(credentialsDto.getUsername());
        if(!patientToValidate.getCredentials().equals(credentialsToValidate)){
            throw new NotAuthorizedException("The username/password is incorrect");
        }
        patientRepo.saveAndFlush(patientToValidate);
        return fullPatientMapper.entityToFullPatientDto(patientToValidate);
    }
}
