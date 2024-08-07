package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullEmployeeDto;
import com.project.hospital_Management_System_Backend.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeeService employeeService;

    @PostMapping("/login")
    public FullEmployeeDto login(@RequestBody CredentialsDto credentialsDTO){
        return employeeService.login(credentialsDTO);
    }
}
