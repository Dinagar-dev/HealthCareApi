package com.example.healthcareapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcareapi.model.Patients;

public interface PatientRepo extends JpaRepository<Patients,Long>{

}
