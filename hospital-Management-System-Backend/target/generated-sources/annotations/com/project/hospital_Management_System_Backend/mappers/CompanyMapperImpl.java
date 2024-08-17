package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AnnouncementsDto;
import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;
import com.project.hospital_Management_System_Backend.dtos.CompanyDto;
import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;
import com.project.hospital_Management_System_Backend.dtos.ProceduresDto;
import com.project.hospital_Management_System_Backend.entities.Announcements;
import com.project.hospital_Management_System_Backend.entities.Appointments;
import com.project.hospital_Management_System_Backend.entities.Company;
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
public class CompanyMapperImpl implements CompanyMapper {

    @Autowired
    private BasicEmployeeMapper basicEmployeeMapper;
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
    public CompanyDto entityToDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setId( company.getId() );
        companyDto.setName( company.getName() );
        companyDto.setDescription( company.getDescription() );
        companyDto.setAnnouncements( announcementsSetToAnnouncementsDtoSet( company.getAnnouncements() ) );
        companyDto.setEmployees( basicEmployeeMapper.entitiesToBasicEmployeeDtos( company.getEmployees() ) );
        companyDto.setPatients( basicPatientMapper.entitiesToBasicPatientDtos( company.getPatients() ) );
        companyDto.setAppointments( appointmentsSetToAppointmentsDtoSet( company.getAppointments() ) );
        companyDto.setPrescriptions( prescriptionsSetToPrescriptionsDtoSet( company.getPrescriptions() ) );
        companyDto.setProcedures( proceduresSetToProceduresDtoSet( company.getProcedures() ) );

        return companyDto;
    }

    @Override
    public Set<CompanyDto> entitiesToDtos(Set<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        Set<CompanyDto> set = new LinkedHashSet<CompanyDto>( Math.max( (int) ( companies.size() / .75f ) + 1, 16 ) );
        for ( Company company : companies ) {
            set.add( entityToDto( company ) );
        }

        return set;
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
