package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.services.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")
public class AnnouncementsController {
    private final AnnouncementService announcementService;
}
