package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;

import java.util.List;

public interface PrescriptionsService {
    PrescriptionsDto createPrescription(Long id, PrescriptionsDto prescriptionsDto);

    List<PrescriptionsDto> getPrescriptions(Long id);

    PrescriptionsDto updatePrescription(Long id, Long prescriptionId, PrescriptionsDto prescriptionsDto);

    void deletePrescription(Long id, Long prescriptionId);
}
