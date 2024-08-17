package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;
import com.project.hospital_Management_System_Backend.dtos.FullPatientDto;
import com.project.hospital_Management_System_Backend.dtos.PatientRequestDto;
import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;
import com.project.hospital_Management_System_Backend.dtos.ProceduresDto;
import com.project.hospital_Management_System_Backend.entities.Appointments;
import com.project.hospital_Management_System_Backend.entities.Patient;
import com.project.hospital_Management_System_Backend.entities.Prescriptions;
import com.project.hospital_Management_System_Backend.entities.Procedures;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:35:25-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FullPatientMapperImpl implements FullPatientMapper {

    @Autowired
    private CredentialsMapper credentialsMapper;
    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private BasicEmployeeMapper basicEmployeeMapper;
    @Autowired
    private AppointmentsMapper appointmentsMapper;
    @Autowired
    private PrescriptionsMapper prescriptionsMapper;
    @Autowired
    private ProceduresMapper proceduresMapper;

    @Override
    public FullPatientDto entityToFullPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        FullPatientDto fullPatientDto = new FullPatientDto();

        fullPatientDto.setId( patient.getId() );
        fullPatientDto.setProfile( profileMapper.entityToDto( patient.getProfile() ) );
        fullPatientDto.setAge( patient.getAge() );
        fullPatientDto.setGender( patient.getGender() );
        fullPatientDto.setAddress( patient.getAddress() );
        fullPatientDto.setPrognosis( patient.getPrognosis() );
        fullPatientDto.setCompanies( companyMapper.entitiesToDtos( patient.getCompanies() ) );
        fullPatientDto.setEmployees( basicEmployeeMapper.entitiesToBasicEmployeeDtos( patient.getEmployees() ) );
        fullPatientDto.setAppointments( appointmentsSetToAppointmentsDtoSet( patient.getAppointments() ) );
        fullPatientDto.setPrescriptions( prescriptionsSetToPrescriptionsDtoSet( patient.getPrescriptions() ) );
        fullPatientDto.setProcedures( proceduresSetToProceduresDtoSet( patient.getProcedures() ) );

        return fullPatientDto;
    }

    @Override
    public Set<FullPatientDto> entitiesToFullPatientDtos(Set<Patient> patients) {
        if ( patients == null ) {
            return null;
        }

        Set<FullPatientDto> set = new LinkedHashSet<FullPatientDto>( Math.max( (int) ( patients.size() / .75f ) + 1, 16 ) );
        for ( Patient patient : patients ) {
            set.add( entityToFullPatientDto( patient ) );
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

    protected Set<AppointmentsDto> appointmentsSetToAppointmentsDtoSet(Set<Appointments> set) {
        if ( set == null ) {
            return null;
        }

        Set<AppointmentsDto> set1 = new LinkedHashSet<AppointmentsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Appointments appointments : set ) {
            set1.add( appointmentsMapper.entityToDto( appointments ) );
        }

        return set1;
    }

    protected Set<PrescriptionsDto> prescriptionsSetToPrescriptionsDtoSet(Set<Prescriptions> set) {
        if ( set == null ) {
            return null;
        }

        Set<PrescriptionsDto> set1 = new LinkedHashSet<PrescriptionsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Prescriptions prescriptions : set ) {
            set1.add( prescriptionsMapper.entityToDto( prescriptions ) );
        }

        return set1;
    }

    protected Set<ProceduresDto> proceduresSetToProceduresDtoSet(Set<Procedures> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProceduresDto> set1 = new LinkedHashSet<ProceduresDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Procedures procedures : set ) {
            set1.add( proceduresMapper.entityToDto( procedures ) );
        }

        return set1;
    }
}
