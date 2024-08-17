package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.BasicPatientDto;
import com.project.hospital_Management_System_Backend.dtos.ProceduresDto;
import com.project.hospital_Management_System_Backend.dtos.ProfileDto;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import com.project.hospital_Management_System_Backend.entities.Procedures;
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
public class ProceduresMapperImpl implements ProceduresMapper {

    @Autowired
    private BasicEmployeeMapper basicEmployeeMapper;
    @Autowired
    private BasicPatientMapper basicPatientMapper;

    @Override
    public ProceduresDto entityToDto(Procedures procedures) {
        if ( procedures == null ) {
            return null;
        }

        ProceduresDto proceduresDto = new ProceduresDto();

        proceduresDto.setId( procedures.getId() );
        proceduresDto.setName( procedures.getName() );
        proceduresDto.setDescription( procedures.getDescription() );
        proceduresDto.setDoctor( basicEmployeeMapper.entityToBasicEmployeeDto( procedures.getDoctor() ) );
        proceduresDto.setPatient( basicPatientMapper.entityToBasicPatientDto( procedures.getPatient() ) );

        return proceduresDto;
    }

    @Override
    public List<ProceduresDto> entitiesToDtos(List<Procedures> procedures) {
        if ( procedures == null ) {
            return null;
        }

        List<ProceduresDto> list = new ArrayList<ProceduresDto>( procedures.size() );
        for ( Procedures procedures1 : procedures ) {
            list.add( entityToDto( procedures1 ) );
        }

        return list;
    }

    @Override
    public Procedures dtoToEntity(ProceduresDto proceduresDto) {
        if ( proceduresDto == null ) {
            return null;
        }

        Procedures procedures = new Procedures();

        procedures.setId( proceduresDto.getId() );
        procedures.setName( proceduresDto.getName() );
        procedures.setDescription( proceduresDto.getDescription() );
        procedures.setDoctor( basicEmployeeDtoToEmployee( proceduresDto.getDoctor() ) );
        procedures.setPatient( basicPatientDtoToPatient( proceduresDto.getPatient() ) );

        return procedures;
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
