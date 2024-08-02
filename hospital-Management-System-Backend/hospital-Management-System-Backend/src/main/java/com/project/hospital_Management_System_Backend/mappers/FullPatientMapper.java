package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.FullPatientDto;
import com.project.hospital_Management_System_Backend.dtos.PatientRequestDto;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = { CredentialsMapper.class, ProfileMapper.class, CompanyMapper.class,BasicEmployeeMapper.class,  AppointmentsMapper.class, PrescriptionsMapper.class, ProceduresMapper.class })
public interface FullPatientMapper {
    FullPatientMapper INSTANCE= Mappers.getMapper(FullPatientMapper.class);
    FullPatientDto entityToFullPatientDto(Patient patient);

    Set<FullPatientDto> entitiesToFullPatientDtos(Set<Patient> patients);

    Patient requestDtoToEntity(PatientRequestDto patientRequestDto);
}
