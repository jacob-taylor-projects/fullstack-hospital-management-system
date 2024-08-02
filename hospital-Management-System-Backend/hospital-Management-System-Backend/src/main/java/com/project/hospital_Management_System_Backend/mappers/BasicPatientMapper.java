package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.BasicPatientDto;
import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.dtos.PatientRequestDto;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class})
public interface BasicPatientMapper {
    BasicPatientMapper INSTANCE= Mappers.getMapper(BasicPatientMapper.class);
    BasicPatientDto entityToBasicPatientDto(Patient patient);

    Set<BasicPatientDto> entitiesToBasicPatientDtos(Set<Patient> patients);



    Patient requestDtoToEntity(PatientRequestDto patientRequestDto);
}
