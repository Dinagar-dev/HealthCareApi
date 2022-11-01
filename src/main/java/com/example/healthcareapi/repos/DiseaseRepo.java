package com.example.healthcareapi.repos;

import com.example.healthcareapi.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepo extends JpaRepository<Disease,Long> {
}
