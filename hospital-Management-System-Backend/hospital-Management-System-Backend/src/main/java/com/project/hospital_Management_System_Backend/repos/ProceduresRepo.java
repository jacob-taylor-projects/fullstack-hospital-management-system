package com.project.hospital_Management_System_Backend.repos;

import com.project.hospital_Management_System_Backend.entities.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProceduresRepo extends JpaRepository<Procedures,Long> {
    Optional<Procedures> findById(Long id);
}
