package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.CompanyDto;
import com.project.hospital_Management_System_Backend.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring", uses = { BasicEmployeeMapper.class,BasicPatientMapper.class, AnnouncementsMapper.class, AppointmentsMapper.class, PrescriptionsMapper.class, ProceduresMapper.class })
public interface CompanyMapper {
    CompanyMapper INSTANCE= Mappers.getMapper(CompanyMapper.class);
    CompanyDto entityToDto(Company company);

    Set<CompanyDto> entitiesToDtos(Set<Company> companies);
}
