package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.ProceduresDto;

import java.util.List;

public interface ProceduresService {
    ProceduresDto createProcedure(Long id, ProceduresDto proceduresDto);

    List<ProceduresDto> getProcedures(Long id);

    ProceduresDto updateProcedure(Long id, Long procedureId, ProceduresDto proceduresDto);

    void deleteProcedure(Long id, Long procedureId);
}
