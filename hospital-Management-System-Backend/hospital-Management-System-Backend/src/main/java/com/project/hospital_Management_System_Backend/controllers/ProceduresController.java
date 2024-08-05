package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.services.ProceduresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/procedures")
@RequiredArgsConstructor
public class ProceduresController {
    private final ProceduresService proceduresService;
}
