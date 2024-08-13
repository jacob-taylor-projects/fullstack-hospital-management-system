package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.BasicEmployeeDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.EmployeeRequestDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;
import com.project.hospital_Management_System_Backend.entities.Company;
import com.project.hospital_Management_System_Backend.entities.Credentials;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.exceptions.BadRequestException;
import com.project.hospital_Management_System_Backend.exceptions.NotAuthorizedException;
import com.project.hospital_Management_System_Backend.mappers.BasicEmployeeMapper;
import com.project.hospital_Management_System_Backend.mappers.CredentialsMapper;
import com.project.hospital_Management_System_Backend.mappers.FullEmployeeMapper;
import com.project.hospital_Management_System_Backend.repos.EmployeeRepo;
import com.project.hospital_Management_System_Backend.services.EmployeeService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final CredentialsMapper credentialsMapper;
    private final ValidateService validateService;
    private final EmployeeRepo employeeRepo;
    private final FullEmployeeMapper fullEmployeeMapper;
    private final BasicEmployeeMapper basicEmployeeMapper;
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

    @Override
    public FullEmployeeDto createEmployee(Long id, EmployeeRequestDto employeeRequestDto) {
        Company company=validateService.findCompany(id);
        if (employeeRequestDto.getCredentials()==null||employeeRequestDto.getProfile()==null||
                employeeRequestDto.getCredentials().getUsername().isEmpty()||
                employeeRequestDto.getCredentials().getPassword().isEmpty() ||
                employeeRequestDto.getProfile().getFirstName().isEmpty() ||
                employeeRequestDto.getProfile().getLastName().isEmpty() ||
                employeeRequestDto.getProfile().getEmail().isEmpty()){
            throw new BadRequestException("missing profile or credentials or both");
        }
        Employee employee=fullEmployeeMapper.requestDtoToEntity(employeeRequestDto);
        employee.getCompanies().add(company);
        employee.setAge(employeeRequestDto.getAge());
        employee.setGender(employeeRequestDto.getGender());
        employee.setAddress(employeeRequestDto.getAddress());
        employee.setSpecialty(employeeRequestDto.getSpecialty());
        employee.setSalary(employeeRequestDto.getSalary());
        try {
            return fullEmployeeMapper.entityToFullEmployeeDto(employeeRepo.saveAndFlush(employee));
        }catch (RuntimeException e){
            throw new BadRequestException("A user with that username already exists.Please try again");
        }
    }

    @Override
    public Set<FullEmployeeDto> getEmployees(Long id) {
        Company company=validateService.findCompany(id);
        Set<Employee> filteredEmployees=new HashSet<>();
        company.getEmployees().forEach(filteredEmployees::add);
        return fullEmployeeMapper.entitiesToFullEmployeeDtos(filteredEmployees);
    }

    @Override
    public BasicEmployeeDto updateEmployee(Long id, Long employeeId, EmployeeRequestDto employeeRequestDto) {
        validateService.findCompany(id);
        Employee employee=validateService.findEmployee(employeeId);
        if(employeeRequestDto.getCredentials()!=null){
            if (employeeRequestDto.getCredentials().getPassword()!=null){
                employee.getCredentials().setPassword(employeeRequestDto.getCredentials().getPassword());

            }
            if (employeeRequestDto.getCredentials().getUsername()!=null){
                employee.getCredentials().setUsername(employeeRequestDto.getCredentials().getUsername());
            }
            if (employeeRequestDto.getProfile()!=null){
                if(employeeRequestDto.getProfile().getEmail()!=null){
                    employee.getProfile().setEmail(employeeRequestDto.getProfile().getEmail());
                }
                if (employeeRequestDto.getProfile().getPhoneNumber()!=null){
                    employee.getProfile().setPhoneNumber(employeeRequestDto.getProfile().getPhoneNumber());
                }
                if(employeeRequestDto.getProfile().getFirstName()!=null){
                    employee.getProfile().setFirstName(employeeRequestDto.getProfile().getFirstName());
                }
                if(employeeRequestDto.getProfile().getLastName()!=null){
                    employee.getProfile().setLastName(employeeRequestDto.getProfile().getLastName());
                }
            }
            if (employeeRequestDto.getAge()!=0){
                employee.setAge(employeeRequestDto.getAge());
            }
            if (employeeRequestDto.getGender()!=null){
                employee.setGender(employeeRequestDto.getGender());
            }
            if (employeeRequestDto.getAddress()!=null){
                employee.setAddress(employeeRequestDto.getAddress());
            }
            if(employeeRequestDto.getSpecialty()!=null){
                employee.setSpecialty(employeeRequestDto.getSpecialty());
            }
            if (employeeRequestDto.getSalary()!=0){
                employee.setSalary(employeeRequestDto.getSalary());
            }
        }
        employeeRepo.saveAndFlush(employee);
        return basicEmployeeMapper.entityToBasicEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long id, Long employeeId) {
        validateService.findCompany(id);
        employeeRepo.deleteById(employeeId);
    }

}
