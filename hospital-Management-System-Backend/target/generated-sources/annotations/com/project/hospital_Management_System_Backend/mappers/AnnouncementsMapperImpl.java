package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AnnouncementsDto;
import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.ProfileDto;
import com.project.hospital_Management_System_Backend.entities.Announcements;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.entities.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:35:24-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AnnouncementsMapperImpl implements AnnouncementsMapper {

    @Autowired
    private BasicEmployeeMapper basicEmployeeMapper;

    @Override
    public AnnouncementsDto entityToDto(Announcements announcement) {
        if ( announcement == null ) {
            return null;
        }

        AnnouncementsDto announcementsDto = new AnnouncementsDto();

        announcementsDto.setId( announcement.getId() );
        announcementsDto.setDate( announcement.getDate() );
        announcementsDto.setTitle( announcement.getTitle() );
        announcementsDto.setMessage( announcement.getMessage() );
        announcementsDto.setAuthor( basicEmployeeMapper.entityToBasicEmployeeDto( announcement.getAuthor() ) );

        return announcementsDto;
    }

    @Override
    public List<AnnouncementsDto> entitiesToDtos(List<Announcements> announcements) {
        if ( announcements == null ) {
            return null;
        }

        List<AnnouncementsDto> list = new ArrayList<AnnouncementsDto>( announcements.size() );
        for ( Announcements announcements1 : announcements ) {
            list.add( entityToDto( announcements1 ) );
        }

        return list;
    }

    @Override
    public Announcements dtoToEntity(AnnouncementsDto announcementsDto) {
        if ( announcementsDto == null ) {
            return null;
        }

        Announcements announcements = new Announcements();

        announcements.setId( announcementsDto.getId() );
        announcements.setDate( announcementsDto.getDate() );
        announcements.setTitle( announcementsDto.getTitle() );
        announcements.setMessage( announcementsDto.getMessage() );
        announcements.setAuthor( basicEmployeeDtoToEmployee( announcementsDto.getAuthor() ) );

        return announcements;
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
}
