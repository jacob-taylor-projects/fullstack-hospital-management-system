package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;
import com.project.hospital_Management_System_Backend.dtos.PrescriptionsDto;
import com.project.hospital_Management_System_Backend.entities.Appointments;
import com.project.hospital_Management_System_Backend.entities.Prescriptions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { BasicEmployeeMapper.class,BasicPatientMapper.class })
public interface PrescriptionsMapper {
    PrescriptionsMapper INSTANCE= Mappers.getMapper(PrescriptionsMapper.class);

    PrescriptionsDto entityToDto(Prescriptions prescriptions);

    List<PrescriptionsDto> entitiesToDtos(List<Prescriptions> prescriptions);

    Prescriptions dtoToEntity(PrescriptionsDto prescriptionsDto);
}
