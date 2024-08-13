package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.ProceduresDto;
import com.project.hospital_Management_System_Backend.entities.*;
import com.project.hospital_Management_System_Backend.mappers.ProceduresMapper;
import com.project.hospital_Management_System_Backend.repos.ProceduresRepo;
import com.project.hospital_Management_System_Backend.services.ProceduresService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProceduresServiceImpl implements ProceduresService {
    private final ValidateService validateService;
    private final ProceduresRepo proceduresRepo;
    private final ProceduresMapper proceduresMapper;
    @Override
    public ProceduresDto createProcedure(Long id, ProceduresDto proceduresDto) {
        validateService.findCompany(id);
        Employee employee=validateService.findEmployee(proceduresDto.getDoctor().getId());
        Patient patient=validateService.findPatient(proceduresDto.getPatient().getId());
        Procedures procedures = proceduresMapper.dtoToEntity(proceduresDto);
        procedures.setDoctor(employee);
        procedures.setPatient(patient);
        Procedures savedProcedure= proceduresRepo.saveAndFlush(procedures);
        return proceduresMapper.entityToDto(savedProcedure);
    }

    @Override
    public List<ProceduresDto> getProcedures(Long id) {
        Company company = validateService.findCompany(id);
        List<Procedures> sortedList = new ArrayList<>(company.getProcedures());
        return proceduresMapper.entitiesToDtos(sortedList);
    }

    @Override
    public ProceduresDto updateProcedure(Long id, Long procedureId, ProceduresDto proceduresDto) {
        validateService.findCompany(id);
        Procedures procedures=validateService.findProcedure(procedureId);
        if (proceduresDto.getName()!=null){
            procedures.setName(proceduresDto.getName());
        }
        if (proceduresDto.getDescription()!=null){
            procedures.setDescription(proceduresDto.getDescription());
        }
        Employee employee=validateService.findEmployee(proceduresDto.getDoctor().getId());
        Patient patient=validateService.findPatient(proceduresDto.getPatient().getId());
        procedures.setDoctor(employee);
        procedures.setPatient(patient);
        return proceduresMapper.entityToDto(proceduresRepo.saveAndFlush(procedures));
    }

    @Override
    public void deleteProcedure(Long id, Long procedureId) {
        validateService.findCompany(id);
        proceduresRepo.deleteById(procedureId);
    }
}
