package com.example.healthcareapi.service;

import com.example.healthcareapi.model.Patients;
import com.example.healthcareapi.projection.PatientProject;
import com.example.healthcareapi.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public Collection<PatientProject> getAllPatient(){
        long id=1;
        return patientRepo.getAllByUserId(id);
    }

    public PatientProject getSinglePatient(Long patientId){
        return patientRepo.findByPatientId(patientId).get();
//        return null;
    }

}
