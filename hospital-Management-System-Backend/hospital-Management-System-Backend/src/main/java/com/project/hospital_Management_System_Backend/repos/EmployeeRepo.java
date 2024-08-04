package com.project.hospital_Management_System_Backend.repos;

import com.project.hospital_Management_System_Backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findById(Long id);
}
