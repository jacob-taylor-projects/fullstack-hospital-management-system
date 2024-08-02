package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class})
public interface BasicEmployeeMapper {
    BasicEmployeeMapper INSTANCE= Mappers.getMapper(BasicEmployeeMapper.class);
    BasicEmployeeDto entityToBasicEmployeeDto(Employee employee);

    Set<BasicEmployeeDto> entitiesToBasicEmployeeDtos(Set<Employee> employees);



    Employee requestDtoToEntity(EmployeeRequestDto employeeRequestDto);
}
