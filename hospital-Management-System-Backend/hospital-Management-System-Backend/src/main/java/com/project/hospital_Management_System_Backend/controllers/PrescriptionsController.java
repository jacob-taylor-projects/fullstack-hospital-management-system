package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.services.PrescriptionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescriptions")
@RequiredArgsConstructor
public class PrescriptionsController {
    private final PrescriptionsService prescriptionsService;
}
