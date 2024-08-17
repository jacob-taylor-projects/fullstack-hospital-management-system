package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;
import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.BasicPatientDto;
import com.project.hospital_Management_System_Backend.dtos.ProfileDto;
import com.project.hospital_Management_System_Backend.entities.Appointments;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Patient;
import com.project.hospital_Management_System_Backend.entities.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:35:26-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AppointmentsMapperImpl implements AppointmentsMapper {

    @Autowired
    private BasicEmployeeMapper basicEmployeeMapper;
    @Autowired
    private BasicPatientMapper basicPatientMapper;

    @Override
    public AppointmentsDto entityToDto(Appointments appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentsDto appointmentsDto = new AppointmentsDto();

        appointmentsDto.setId( appointment.getId() );
        appointmentsDto.setName( appointment.getName() );
        appointmentsDto.setDescription( appointment.getDescription() );
        appointmentsDto.setDate( appointment.getDate() );
        appointmentsDto.setStartTime( appointment.getStartTime() );
        appointmentsDto.setEndTime( appointment.getEndTime() );
        appointmentsDto.setDoctor( basicEmployeeMapper.entityToBasicEmployeeDto( appointment.getDoctor() ) );
        appointmentsDto.setPatient( basicPatientMapper.entityToBasicPatientDto( appointment.getPatient() ) );

        return appointmentsDto;
    }

    @Override
    public List<AppointmentsDto> entitiesToDtos(List<Appointments> appointments) {
        if ( appointments == null ) {
            return null;
        }

        List<AppointmentsDto> list = new ArrayList<AppointmentsDto>( appointments.size() );
        for ( Appointments appointments1 : appointments ) {
            list.add( entityToDto( appointments1 ) );
        }

        return list;
    }

    @Override
    public Appointments dtoToEntity(AppointmentsDto appointmentsDto) {
        if ( appointmentsDto == null ) {
            return null;
        }

        Appointments appointments = new Appointments();

        appointments.setId( appointmentsDto.getId() );
        appointments.setName( appointmentsDto.getName() );
        appointments.setDescription( appointmentsDto.getDescription() );
        appointments.setDate( appointmentsDto.getDate() );
        appointments.setStartTime( appointmentsDto.getStartTime() );
        appointments.setEndTime( appointmentsDto.getEndTime() );
        appointments.setDoctor( basicEmployeeDtoToEmployee( appointmentsDto.getDoctor() ) );
        appointments.setPatient( basicPatientDtoToPatient( appointmentsDto.getPatient() ) );

        return appointments;
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
