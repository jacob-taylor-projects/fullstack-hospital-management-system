package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.dtos.CompanyDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/all-employees")
    public Set<CompanyDto> getAllEmployeesCompanies(@RequestBody CredentialsDto credentialDto){
        return companyService.getAllEmployeesCompanies(credentialDto);
    }
    @GetMapping("/all-patients")
    public Set<CompanyDto> getAllPatientsCompanies(@RequestBody CredentialsDto credentialDto){
        return companyService.getAllPatientsCompanies(credentialDto);
    }
}
