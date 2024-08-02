package com.project.hospital_Management_System_Backend.mappers;

import com.project.hospital_Management_System_Backend.dtos.AnnouncementsDto;
import com.project.hospital_Management_System_Backend.entities.Announcements;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = { BasicEmployeeMapper.class })
public interface AnnouncementsMapper {
    AnnouncementsMapper INSTANCE= Mappers.getMapper(AnnouncementsMapper.class);
    AnnouncementsDto entityToDto(Announcements announcement);

    List<AnnouncementsDto> entitiesToDtos(List<Announcements> announcements);

    Announcements dtoToEntity(AnnouncementsDto announcementsDto);
}
