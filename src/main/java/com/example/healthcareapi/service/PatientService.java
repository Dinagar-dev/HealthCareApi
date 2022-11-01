package com.example.healthcareapi.service;

import com.example.healthcareapi.model.Patients;
import com.example.healthcareapi.projection.PatientProject;
import com.example.healthcareapi.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    public List<Patients> getAllPatient(){
//        long id=1;
        return patientRepo.findAll();
    }

    public Patients getSinglePatient(Long patientId){
        return patientRepo.findByPatientId(patientId).orElse(null);
//        return null;
    }

    public Patients getSinglePatient(String name){

        return patientRepo.findByPatientName(name).orElse(null);
    }

}
