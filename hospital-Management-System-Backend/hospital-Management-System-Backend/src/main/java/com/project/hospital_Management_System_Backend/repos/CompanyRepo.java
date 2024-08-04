package com.project.hospital_Management_System_Backend.repos;

import com.project.hospital_Management_System_Backend.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    Optional<Company> findById(Long id);
}