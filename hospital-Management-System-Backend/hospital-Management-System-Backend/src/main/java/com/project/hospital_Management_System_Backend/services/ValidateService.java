package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.entities.*;

public interface ValidateService {
    Employee findEmployee(String username);

    Patient findPatient(String username);

    Company findCompany(Long id);

    Employee findEmployee(Long id);

    Announcements findAnnouncement(Long id);

    Patient findPatient(Long id);

    Prescriptions findPrescription(Long id);
}
