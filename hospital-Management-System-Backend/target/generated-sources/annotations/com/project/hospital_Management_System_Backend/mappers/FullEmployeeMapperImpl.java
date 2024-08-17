package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AnnouncementsDto;
import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;
import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;
import com.project.hospital_Management_System_Backend.dtos.ProceduresDto;
import com.project.hospital_Management_System_Backend.entities.Announcements;
import com.project.hospital_Management_System_Backend.entities.Appointments;
import com.project.hospital_Management_System_Backend.entities.Employee;
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
public class FullEmployeeMapperImpl implements FullEmployeeMapper {

    @Autowired
    private CredentialsMapper credentialsMapper;
    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private BasicPatientMapper basicPatientMapper;
    @Autowired
    private AnnouncementsMapper announcementsMapper;
    @Autowired
    private AppointmentsMapper appointmentsMapper;
    @Autowired
    private PrescriptionsMapper prescriptionsMapper;
    @Autowired
    private ProceduresMapper proceduresMapper;

    @Override
    public FullEmployeeDto entityToFullEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        FullEmployeeDto fullEmployeeDto = new FullEmployeeDto();

        fullEmployeeDto.setId( employee.getId() );
        fullEmployeeDto.setProfile( profileMapper.entityToDto( employee.getProfile() ) );
        fullEmployeeDto.setAge( employee.getAge() );
        fullEmployeeDto.setGender( employee.getGender() );
        fullEmployeeDto.setAddress( employee.getAddress() );
        fullEmployeeDto.setAdmin( employee.isAdmin() );
        fullEmployeeDto.setDoctor( employee.isDoctor() );
        fullEmployeeDto.setSpecialty( employee.getSpecialty() );
        fullEmployeeDto.setSalary( employee.getSalary() );
        fullEmployeeDto.setAnnouncements( announcementsSetToAnnouncementsDtoSet( employee.getAnnouncements() ) );
        fullEmployeeDto.setCompanies( companyMapper.entitiesToDtos( employee.getCompanies() ) );
        fullEmployeeDto.setPatients( basicPatientMapper.entitiesToBasicPatientDtos( employee.getPatients() ) );
        fullEmployeeDto.setAppointments( appointmentsSetToAppointmentsDtoSet( employee.getAppointments() ) );
        fullEmployeeDto.setPrescriptions( prescriptionsSetToPrescriptionsDtoSet( employee.getPrescriptions() ) );
        fullEmployeeDto.setProcedures( proceduresSetToProceduresDtoSet( employee.getProcedures() ) );

        return fullEmployeeDto;
    }

    @Override
    public Set<FullEmployeeDto> entitiesToFullEmployeeDtos(Set<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        Set<FullEmployeeDto> set = new LinkedHashSet<FullEmployeeDto>( Math.max( (int) ( employees.size() / .75f ) + 1, 16 ) );
        for ( Employee employee : employees ) {
            set.add( entityToFullEmployeeDto( employee ) );
        }

        return set;
    }

    @Override
    public Employee requestDtoToEntity(EmployeeRequestDto employeeRequestDto) {
        if ( employeeRequestDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setCredentials( credentialsMapper.dtoToEntity( employeeRequestDto.getCredentials() ) );
        employee.setProfile( profileMapper.dtoToEntity( employeeRequestDto.getProfile() ) );
        employee.setAdmin( employeeRequestDto.isAdmin() );
        employee.setDoctor( employeeRequestDto.isDoctor() );

        return employee;
    }

    protected Set<AnnouncementsDto> announcementsSetToAnnouncementsDtoSet(Set<Announcements> set) {
        if ( set == null ) {
            return null;
        }

        Set<AnnouncementsDto> set1 = new LinkedHashSet<AnnouncementsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Announcements announcements : set ) {
            set1.add( announcementsMapper.entityToDto( announcements ) );
        }

        return set1;
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
