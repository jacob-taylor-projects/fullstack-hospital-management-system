package com.project.hospital_Management_System_Backend.services;

import com.project.hospital_Management_System_Backend.dtos.AnnouncementsDto;

import java.util.List;

public interface AnnouncementService {
    AnnouncementsDto postAnnouncement(Long id, AnnouncementsDto announcementsDto);

    List<AnnouncementsDto> getAnnouncements(Long id);

    AnnouncementsDto updateAnnouncement(Long id, Long announcementId, AnnouncementsDto announcementsDto);

    void deleteAnnouncement(Long id, Long announcementId);
}
