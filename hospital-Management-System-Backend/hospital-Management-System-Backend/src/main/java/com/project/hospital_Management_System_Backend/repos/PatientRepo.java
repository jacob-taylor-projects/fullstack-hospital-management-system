package com.project.hospital_Management_System_Backend.repos;

import com.project.hospital_Management_System_Backend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
    Optional<Patient> findById(Long id);
}
