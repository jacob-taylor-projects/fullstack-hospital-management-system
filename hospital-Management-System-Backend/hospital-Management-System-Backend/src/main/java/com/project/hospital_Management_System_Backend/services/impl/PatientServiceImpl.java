package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.BasicPatientDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullPatientDto;
import com.project.hospital_Management_System_Backend.dtos.PatientRequestDto;
import com.project.hospital_Management_System_Backend.entities.Company;
import com.project.hospital_Management_System_Backend.entities.Credentials;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import com.project.hospital_Management_System_Backend.exceptions.BadRequestException;
import com.project.hospital_Management_System_Backend.exceptions.NotAuthorizedException;
import com.project.hospital_Management_System_Backend.mappers.BasicPatientMapper;
import com.project.hospital_Management_System_Backend.mappers.CredentialsMapper;
import com.project.hospital_Management_System_Backend.mappers.FullPatientMapper;
import com.project.hospital_Management_System_Backend.repos.PatientRepo;
import com.project.hospital_Management_System_Backend.services.PatientService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final CredentialsMapper credentialsMapper;
    private final ValidateService validateService;
    private final PatientRepo patientRepo;
    private final FullPatientMapper fullPatientMapper;
    private final BasicPatientMapper basicPatientMapper;
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

    @Override
    public FullPatientDto createPatient(Long id, PatientRequestDto patientRequestDto) {
        Company company=validateService.findCompany(id);
        if (patientRequestDto.getCredentials()==null||patientRequestDto.getProfile()==null||
                patientRequestDto.getCredentials().getUsername().isEmpty()||
                patientRequestDto.getCredentials().getPassword().isEmpty() ||
                patientRequestDto.getProfile().getFirstName().isEmpty() ||
                patientRequestDto.getProfile().getLastName().isEmpty() ||
                patientRequestDto.getProfile().getEmail().isEmpty()){
            throw new BadRequestException("missing profile or credentials or both");
        }
        Patient patient=fullPatientMapper.requestDtoToEntity(patientRequestDto);
        patient.getCompanies().add(company);
        patient.setAge(patientRequestDto.getAge());
        patient.setGender(patientRequestDto.getGender());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setPrognosis(patientRequestDto.getPrognosis());
        try {
            return fullPatientMapper.entityToFullPatientDto(patientRepo.saveAndFlush(patient));
        }catch (RuntimeException e){
            throw new BadRequestException("A user with that username already exists.Please try again");
        }
    }

    @Override
    public Set<FullPatientDto> getPatients(Long id) {
        Company company=validateService.findCompany(id);
        Set<Patient> filteredPatients=new HashSet<>();
        company.getPatients().forEach(filteredPatients::add);
        return fullPatientMapper.entitiesToFullPatientDtos(filteredPatients);
    }

    @Override
    public BasicPatientDto updatePatient(Long id, Long patientId, PatientRequestDto patientRequestDto) {
        validateService.findCompany(id);
        Patient patient=validateService.findPatient(patientId);
        if(patientRequestDto.getCredentials()!=null){
            if (patientRequestDto.getCredentials().getPassword()!=null){
                patient.getCredentials().setPassword(patientRequestDto.getCredentials().getPassword());

            }
            if (patientRequestDto.getCredentials().getUsername()!=null){
                patient.getCredentials().setUsername(patientRequestDto.getCredentials().getUsername());
            }
            if (patientRequestDto.getProfile()!=null){
                if(patientRequestDto.getProfile().getEmail()!=null){
                    patient.getProfile().setEmail(patientRequestDto.getProfile().getEmail());
                }
                if (patientRequestDto.getProfile().getPhoneNumber()!=null){
                    patient.getProfile().setPhoneNumber(patientRequestDto.getProfile().getPhoneNumber());
                }
                if(patientRequestDto.getProfile().getFirstName()!=null){
                    patient.getProfile().setFirstName(patientRequestDto.getProfile().getFirstName());
                }
                if(patientRequestDto.getProfile().getLastName()!=null){
                    patient.getProfile().setLastName(patientRequestDto.getProfile().getLastName());
                }
            }
            if (patientRequestDto.getAge()!=0){
                patient.setAge(patientRequestDto.getAge());
            }
            if (patientRequestDto.getGender()!=null){
                patient.setGender(patientRequestDto.getGender());
            }
            if (patientRequestDto.getAddress()!=null){
                patient.setAddress(patientRequestDto.getAddress());
            }
            if (patientRequestDto.getPrognosis()!=null){
                patient.setPrognosis(patientRequestDto.getPrognosis());
            }
        }
        patientRepo.saveAndFlush(patient);
        return basicPatientMapper.entityToBasicPatientDto(patient);
    }

    @Override
    public void deletePatient(Long id, Long patientId) {
        validateService.findCompany(id);
        patientRepo.deleteById(patientId);

    }

}
