package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.entities.Employee;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:35:24-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BasicEmployeeMapperImpl implements BasicEmployeeMapper {

    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private CredentialsMapper credentialsMapper;

    @Override
    public BasicEmployeeDto entityToBasicEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        BasicEmployeeDto basicEmployeeDto = new BasicEmployeeDto();

        basicEmployeeDto.setId( employee.getId() );
        basicEmployeeDto.setProfile( profileMapper.entityToDto( employee.getProfile() ) );
        basicEmployeeDto.setAge( employee.getAge() );
        basicEmployeeDto.setGender( employee.getGender() );
        basicEmployeeDto.setAddress( employee.getAddress() );
        basicEmployeeDto.setAdmin( employee.isAdmin() );
        basicEmployeeDto.setDoctor( employee.isDoctor() );
        basicEmployeeDto.setSpecialty( employee.getSpecialty() );
        basicEmployeeDto.setSalary( employee.getSalary() );

        return basicEmployeeDto;
    }

    @Override
    public Set<BasicEmployeeDto> entitiesToBasicEmployeeDtos(Set<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        Set<BasicEmployeeDto> set = new LinkedHashSet<BasicEmployeeDto>( Math.max( (int) ( employees.size() / .75f ) + 1, 16 ) );
        for ( Employee employee : employees ) {
            set.add( entityToBasicEmployeeDto( employee ) );
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
}
