package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.dtos.FullPatientDto;
import com.project.hospital_Management_System_Backend.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PatientsController {
    private final PatientService patientService;
    @PostMapping("/login")
    public FullPatientDto login(@RequestBody CredentialsDto credentialsDTO){
        return patientService.login(credentialsDTO);
    }
}
