package com.example.healthcareapi.service;

import com.example.healthcareapi.model.Patients;
import com.example.healthcareapi.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    PatientRepo patientRepo;

    @Autowired
    PatientService(PatientRepo patientRepo){
        this.patientRepo=patientRepo;
    }
    public boolean register(Patients patients){
        patientRepo.save(patients);
        return true;
    }

    public Patients getAllPatient(){
        return patientRepo.getAll().get();
    }

}
