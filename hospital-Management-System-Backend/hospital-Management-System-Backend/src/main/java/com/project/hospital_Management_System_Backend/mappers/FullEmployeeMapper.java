package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;
import com.project.hospital_Management_System_Backend.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = { CredentialsMapper.class, ProfileMapper.class, CompanyMapper.class,BasicPatientMapper.class, AnnouncementsMapper.class, AppointmentsMapper.class, PrescriptionsMapper.class, ProceduresMapper.class })
public interface FullEmployeeMapper {
    FullEmployeeMapper INSTANCE= Mappers.getMapper(FullEmployeeMapper.class);
    FullEmployeeDto entityToFullEmployeeDto(Employee employee);

    Set<FullEmployeeDto> entitiesToFullEmployeeDtos(Set<Employee> employees);

    Employee requestDtoToEntity(EmployeeRequestDto employeeRequestDto);
}
