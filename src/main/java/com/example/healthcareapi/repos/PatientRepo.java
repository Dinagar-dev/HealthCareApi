package com.example.healthcareapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcareapi.model.Patients;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patients,Long>{


    @Query(name = "${getAll}",
            nativeQuery = true)
    Optional<Patients> getAll();
}
