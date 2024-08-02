package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AppointmentsDto;
import com.project.hospital_Management_System_Backend.entities.Appointments;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { BasicEmployeeMapper.class,BasicPatientMapper.class })
public interface AppointmentsMapper {
    AppointmentsMapper INSTANCE= Mappers.getMapper(AppointmentsMapper.class);

    AppointmentsDto entityToDto(Appointments appointment);

    List<AppointmentsDto> entitiesToDtos(List<Appointments> appointments);

    Appointments dtoToEntity(AppointmentsDto appointmentsDto);
}
