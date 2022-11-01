package com.example.healthcareapi.repos;

import com.example.healthcareapi.projection.PatientProject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcareapi.model.Patients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patients,Long>{
    @Query(value = "select * from patient",nativeQuery = true)
    List<Patients> getAllByUserId();

//    Optional<PatientProject> findbypatientid(Long Id);

    @Query(value = "select * from patients where patientid=?1",nativeQuery = true)
    Optional<Patients> findByPatientId(Long id);


    @Query(value="select * from patients where patient_name=?1",nativeQuery = true)
    Optional<Patients> findByPatientName(String name);
}
