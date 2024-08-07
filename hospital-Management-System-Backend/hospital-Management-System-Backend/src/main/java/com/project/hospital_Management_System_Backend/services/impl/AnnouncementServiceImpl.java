package com.project.hospital_Management_System_Backend.services.impl;

import com.project.hospital_Management_System_Backend.dtos.AnnouncementsDto;
import com.project.hospital_Management_System_Backend.entities.Announcements;
import com.project.hospital_Management_System_Backend.entities.Company;
import com.project.hospital_Management_System_Backend.entities.Employee;
import com.project.hospital_Management_System_Backend.exceptions.BadRequestException;
import com.project.hospital_Management_System_Backend.mappers.AnnouncementsMapper;
import com.project.hospital_Management_System_Backend.mappers.BasicEmployeeMapper;
import com.project.hospital_Management_System_Backend.repos.AnnouncementsRepo;
import com.project.hospital_Management_System_Backend.services.AnnouncementService;
import com.project.hospital_Management_System_Backend.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final ValidateService validateService;
    private final AnnouncementsMapper announcementsMapper;
    private final AnnouncementsRepo announcementsRepo;
    private final BasicEmployeeMapper basicEmployeeMapper;

    @Override
    public AnnouncementsDto postAnnouncement(Long id, AnnouncementsDto announcementsDto) {
        Company company = validateService.findCompany(id);
        Employee employee = validateService.findEmployee(announcementsDto.getAuthor().getId());
        Announcements announcement = announcementsMapper.dtoToEntity(announcementsDto);
        announcement.setDate(Timestamp.valueOf(LocalDateTime.now()));
        announcement.setCompany(company);
        announcement.getAuthor().setProfile(employee.getProfile());
        Announcements savedAnnouncement = announcementsRepo.save(announcement);
        return announcementsMapper.entityToDto(savedAnnouncement);
    }

    @Override
    public List<AnnouncementsDto> getAnnouncements(Long id) {
        Company company = validateService.findCompany(id);
        List<Announcements> sortedList = new ArrayList<>(company.getAnnouncements());
        sortedList.sort(Comparator.comparing(Announcements::getDate).reversed());
        return announcementsMapper.entitiesToDtos(sortedList);
    }

    @Override
    public AnnouncementsDto updateAnnouncement(Long id, Long announcementId, AnnouncementsDto announcementsDto) {
        validateService.findCompany(id);

        Announcements announcements = validateService.findAnnouncement(announcementId);
        if (announcementsDto.getTitle() != null) {
            announcements.setTitle(announcementsDto.getTitle());
        }
        if (announcementsDto.getDate() != null) {
            announcements.setDate(Timestamp.from(Instant.now()));
        }
        if (announcementsDto.getMessage() != null) {
            announcements.setMessage(announcementsDto.getMessage());
        }
        return announcementsMapper.entityToDto(announcementsRepo.saveAndFlush(announcements));
    }

    @Override
    public void deleteAnnouncement(Long id, Long announcementId) {
        validateService.findCompany(id);
        announcementsRepo.deleteById(announcementId);
    }

}
