package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.BasicPatientDto;
import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;
import com.project.hospital_Management_System_Backend.dtos.ProfileDto;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import com.project.hospital_Management_System_Backend.entities.Prescriptions;
import com.project.hospital_Management_System_Backend.entities.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:35:25-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PrescriptionsMapperImpl implements PrescriptionsMapper {

    @Autowired
    private BasicEmployeeMapper basicEmployeeMapper;
    @Autowired
    private BasicPatientMapper basicPatientMapper;

    @Override
    public PrescriptionsDto entityToDto(Prescriptions prescriptions) {
        if ( prescriptions == null ) {
            return null;
        }

        PrescriptionsDto prescriptionsDto = new PrescriptionsDto();

        prescriptionsDto.setId( prescriptions.getId() );
        prescriptionsDto.setName( prescriptions.getName() );
        prescriptionsDto.setDescription( prescriptions.getDescription() );
        prescriptionsDto.setPrescriber( basicEmployeeMapper.entityToBasicEmployeeDto( prescriptions.getPrescriber() ) );
        prescriptionsDto.setPrescribed( basicPatientMapper.entityToBasicPatientDto( prescriptions.getPrescribed() ) );

        return prescriptionsDto;
    }

    @Override
    public List<PrescriptionsDto> entitiesToDtos(List<Prescriptions> prescriptions) {
        if ( prescriptions == null ) {
            return null;
        }

        List<PrescriptionsDto> list = new ArrayList<PrescriptionsDto>( prescriptions.size() );
        for ( Prescriptions prescriptions1 : prescriptions ) {
            list.add( entityToDto( prescriptions1 ) );
        }

        return list;
    }

    @Override
    public Prescriptions dtoToEntity(PrescriptionsDto prescriptionsDto) {
        if ( prescriptionsDto == null ) {
            return null;
        }

        Prescriptions prescriptions = new Prescriptions();

        prescriptions.setId( prescriptionsDto.getId() );
        prescriptions.setName( prescriptionsDto.getName() );
        prescriptions.setDescription( prescriptionsDto.getDescription() );
        prescriptions.setPrescriber( basicEmployeeDtoToEmployee( prescriptionsDto.getPrescriber() ) );
        prescriptions.setPrescribed( basicPatientDtoToPatient( prescriptionsDto.getPrescribed() ) );

        return prescriptions;
    }

    protected Profile profileDtoToProfile(ProfileDto profileDto) {
        if ( profileDto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setFirstName( profileDto.getFirstName() );
        profile.setLastName( profileDto.getLastName() );
        profile.setEmail( profileDto.getEmail() );
        profile.setPhoneNumber( profileDto.getPhoneNumber() );

        return profile;
    }

    protected Employee basicEmployeeDtoToEmployee(BasicEmployeeDto basicEmployeeDto) {
        if ( basicEmployeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( basicEmployeeDto.getId() );
        employee.setProfile( profileDtoToProfile( basicEmployeeDto.getProfile() ) );
        employee.setAge( basicEmployeeDto.getAge() );
        employee.setGender( basicEmployeeDto.getGender() );
        employee.setAddress( basicEmployeeDto.getAddress() );
        employee.setAdmin( basicEmployeeDto.isAdmin() );
        employee.setDoctor( basicEmployeeDto.isDoctor() );
        employee.setSpecialty( basicEmployeeDto.getSpecialty() );
        employee.setSalary( basicEmployeeDto.getSalary() );

        return employee;
    }

    protected Patient basicPatientDtoToPatient(BasicPatientDto basicPatientDto) {
        if ( basicPatientDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( basicPatientDto.getId() );
        patient.setProfile( profileDtoToProfile( basicPatientDto.getProfile() ) );
        patient.setAge( basicPatientDto.getAge() );
        patient.setGender( basicPatientDto.getGender() );
        patient.setAddress( basicPatientDto.getAddress() );
        patient.setPrognosis( basicPatientDto.getPrognosis() );

        return patient;
    }
}
