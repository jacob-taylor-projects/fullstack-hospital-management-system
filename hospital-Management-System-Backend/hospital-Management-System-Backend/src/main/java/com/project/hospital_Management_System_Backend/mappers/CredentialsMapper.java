package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.entities.Credentials;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CredentialsMapper {
    CredentialsMapper INSTANCE= Mappers.getMapper(CredentialsMapper.class);
    Credentials dtoToEntity(CredentialsDto credentialDto);
}
