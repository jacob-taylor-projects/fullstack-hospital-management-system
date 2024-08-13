package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;
import com.project.hospital_Management_System_Backend.entities.*;
import com.project.hospital_Management_System_Backend.mappers.PrescriptionsMapper;
import com.project.hospital_Management_System_Backend.repos.PrescriptionsRepo;
import com.project.hospital_Management_System_Backend.services.PrescriptionsService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionsServiceImpl implements PrescriptionsService {
    private final ValidateService validateService;
    private final PrescriptionsMapper prescriptionsMapper;
    private final PrescriptionsRepo prescriptionsRepo;
    @Override
    public PrescriptionsDto createPrescription(Long id, PrescriptionsDto prescriptionsDto) {
        validateService.findCompany(id);
        Employee employee=validateService.findEmployee(prescriptionsDto.getPrescriber().getId());
        Patient patient=validateService.findPatient(prescriptionsDto.getPrescribed().getId());
       Prescriptions prescriptions= prescriptionsMapper.dtoToEntity(prescriptionsDto);
       prescriptions.setPrescriber(employee);
       prescriptions.setPrescribed(patient);
      Prescriptions savedPrescription= prescriptionsRepo.saveAndFlush(prescriptions);
       return prescriptionsMapper.entityToDto(savedPrescription);
    }

    @Override
    public List<PrescriptionsDto> getPrescriptions(Long id) {
        Company company = validateService.findCompany(id);
        List<Prescriptions> sortedList = new ArrayList<>(prescriptionsRepo.findAll());
        return prescriptionsMapper.entitiesToDtos(sortedList);
    }

    @Override
    public PrescriptionsDto updatePrescription(Long id, Long prescriptionId, PrescriptionsDto prescriptionsDto) {
        validateService.findCompany(id);
        Prescriptions prescriptions=validateService.findPrescription(prescriptionId);
        if (prescriptionsDto.getName()!=null){
            prescriptions.setName(prescriptionsDto.getName());
        }
        if (prescriptionsDto.getDescription()!=null){
            prescriptions.setDescription(prescriptionsDto.getDescription());
        }
        Employee employee=validateService.findEmployee(prescriptionsDto.getPrescriber().getId());
        Patient patient=validateService.findPatient(prescriptionsDto.getPrescribed().getId());
        prescriptions.setPrescriber(employee);
        prescriptions.setPrescribed(patient);
        return prescriptionsMapper.entityToDto(prescriptionsRepo.saveAndFlush(prescriptions));
    }

    @Override
    public void deletePrescription(Long id, Long prescriptionId) {
        validateService.findCompany(id);
        prescriptionsRepo.deleteById(prescriptionId);
    }
}
