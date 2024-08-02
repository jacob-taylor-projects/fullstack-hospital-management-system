package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;
import com.project.hospital_Management_System_Backend.dtos.ProceduresDto;
import com.project.hospital_Management_System_Backend.entities.Prescriptions;
import com.project.hospital_Management_System_Backend.entities.Procedures;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { BasicEmployeeMapper.class,BasicPatientMapper.class })
public interface ProceduresMapper {
    ProceduresMapper INSTANCE= Mappers.getMapper(ProceduresMapper.class);

    ProceduresDto entityToDto(Procedures procedures);

    List<ProceduresDto> entitiesToDtos(List<Procedures> procedures);

    Procedures dtoToEntity(ProceduresDto proceduresDto);
}
