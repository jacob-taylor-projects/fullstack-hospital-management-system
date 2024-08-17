package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.BasicPatientDto;
import com.project.hospital_Management_System_Backend.dtos.PatientRequestDto;
import com.project.hospital_Management_System_Backend.entities.Patient;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:35:26-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BasicPatientMapperImpl implements BasicPatientMapper {

    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private CredentialsMapper credentialsMapper;

    @Override
    public BasicPatientDto entityToBasicPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        BasicPatientDto basicPatientDto = new BasicPatientDto();

        basicPatientDto.setId( patient.getId() );
        basicPatientDto.setProfile( profileMapper.entityToDto( patient.getProfile() ) );
        basicPatientDto.setAge( patient.getAge() );
        basicPatientDto.setGender( patient.getGender() );
        basicPatientDto.setAddress( patient.getAddress() );
        basicPatientDto.setPrognosis( patient.getPrognosis() );

        return basicPatientDto;
    }

    @Override
    public Set<BasicPatientDto> entitiesToBasicPatientDtos(Set<Patient> patients) {
        if ( patients == null ) {
            return null;
        }

        Set<BasicPatientDto> set = new LinkedHashSet<BasicPatientDto>( Math.max( (int) ( patients.size() / .75f ) + 1, 16 ) );
        for ( Patient patient : patients ) {
            set.add( entityToBasicPatientDto( patient ) );
        }

        return set;
    }

    @Override
    public Patient requestDtoToEntity(PatientRequestDto patientRequestDto) {
        if ( patientRequestDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setCredentials( credentialsMapper.dtoToEntity( patientRequestDto.getCredentials() ) );
        patient.setProfile( profileMapper.dtoToEntity( patientRequestDto.getProfile() ) );

        return patient;
    }
}
