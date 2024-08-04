package com.project.hospital_Management_System_Backend.repos;

import com.project.hospital_Management_System_Backend.entities.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementsRepo extends JpaRepository<Announcements,Long> {

    Optional<Announcements> findById(Long id);
}
