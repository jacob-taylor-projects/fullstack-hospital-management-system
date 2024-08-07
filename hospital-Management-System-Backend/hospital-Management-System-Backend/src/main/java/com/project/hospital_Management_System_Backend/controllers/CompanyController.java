package com.project.hospital_Management_System_Backend.controllers;

import com.project.hospital_Management_System_Backend.dtos.AnnouncementsDto;
import com.project.hospital_Management_System_Backend.dtos.CompanyDto;
import com.project.hospital_Management_System_Backend.dtos.CredentialsDto;
import com.project.hospital_Management_System_Backend.services.AnnouncementService;
import com.project.hospital_Management_System_Backend.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyService companyService;
    private final AnnouncementService announcementService;

    @GetMapping("/all-employees")
    public Set<CompanyDto> getAllEmployeesCompanies(@RequestBody CredentialsDto credentialDto){
        return companyService.getAllEmployeesCompanies(credentialDto);
    }
    @GetMapping("/all-patients")
    public Set<CompanyDto> getAllPatientsCompanies(@RequestBody CredentialsDto credentialDto){
        return companyService.getAllPatientsCompanies(credentialDto);
    }

    @PostMapping("/{id}/announcement")
    @ResponseStatus(HttpStatus.CREATED)
    public AnnouncementsDto postAnnouncement(@PathVariable Long id, @RequestBody AnnouncementsDto announcementsDto){
        return announcementService.postAnnouncement(id, announcementsDto);
    }

    @GetMapping("/{id}/announcements")
    public List<AnnouncementsDto> getAnnouncements(@PathVariable Long id){
        return announcementService.getAnnouncements(id);
    }

    @PutMapping("/{id}/announcement/{announcementId}")
    public AnnouncementsDto updateAnnouncement(@PathVariable Long id,@PathVariable Long announcementId,@RequestBody AnnouncementsDto announcementsDto){
        return announcementService.updateAnnouncement(id,announcementId, announcementsDto);
    }
    @DeleteMapping("/{id}/announcement/{announcementId}")
    public void deleteAnnouncement(@PathVariable Long id,@PathVariable Long announcementId){
        announcementService.deleteAnnouncement(id,announcementId);
    }
}
