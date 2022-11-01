package com.example.healthcareapi.repos;

import com.example.healthcareapi.projection.PatientProject;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcareapi.model.Patients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patients,Long>{
    @Query(value = "select * from patients where user_id=?1",nativeQuery = true)
    Collection<PatientProject> getAllByUserId(Long userId);

//    Optional<PatientProject> findbypatientid(Long Id);

    @Query(value = "select * from patients where patientid=?1",nativeQuery = true)
    Optional<PatientProject> findByPatientId(Long aLong);
}
