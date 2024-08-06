package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;
import com.project.hospital_Management_System_Backend.entities.Credentials;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.exceptions.BadRequestException;
import com.project.hospital_Management_System_Backend.exceptions.NotAuthorizedException;
import com.project.hospital_Management_System_Backend.mappers.CredentialsMapper;
import com.project.hospital_Management_System_Backend.mappers.FullEmployeeMapper;
import com.project.hospital_Management_System_Backend.repos.EmployeeRepo;
import com.project.hospital_Management_System_Backend.services.EmployeeService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final CredentialsMapper credentialsMapper;
    private final ValidateService validateService;
    private final EmployeeRepo employeeRepo;
    private final FullEmployeeMapper fullEmployeeMapper;
    @Override
    public FullEmployeeDto login(CredentialsDto credentialsDto) {
        if(credentialsDto==null||credentialsDto.getUsername()==null||credentialsDto.getPassword()==null){
            throw new BadRequestException("A username and password are needed");
        }
        Credentials credentialsToValidate=credentialsMapper.dtoToEntity(credentialsDto);
        Employee employeeToValidate=validateService.findEmployee(credentialsDto.getUsername());
        if(!employeeToValidate.getCredentials().equals(credentialsToValidate)){
            throw new NotAuthorizedException("The username/password is incorrect");
        }
        employeeRepo.saveAndFlush(employeeToValidate);
        return fullEmployeeMapper.entityToFullEmployeeDto(employeeToValidate);
    }
}
