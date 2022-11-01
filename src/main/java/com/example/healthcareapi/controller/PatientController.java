package com.example.healthcareapi.controller;

import com.example.healthcareapi.model.Patients;
import com.example.healthcareapi.repos.DiseaseRepo;
import com.example.healthcareapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private PatientService patientService;
    private DiseaseRepo diseaseRepo;
    @Autowired
    PatientController(PatientService patientService,DiseaseRepo diseaseRepo){
        this.patientService=patientService;
        this.diseaseRepo=diseaseRepo;
    }

    @GetMapping
    public String defaultMethod(){
        return "default";
    }

    @PostMapping("/register/patient")
    public ResponseEntity<?> doPatientRegistration(@RequestBody Patients patients){
        patientService.register(patients);
        return new ResponseEntity<>("Registered successfully", HttpStatus.OK);
    }


    @GetMapping("/patients/list")
    public ResponseEntity<?> getAllPatientList(){
        return new ResponseEntity<>(patientService.getAllPatient(),HttpStatus.OK);
    }

    @GetMapping("/patients/view/{id}")
    public ResponseEntity<?> getSinglePatient(@PathVariable("id") Long patientId){
        return new ResponseEntity<>(patientService.getSinglePatient(patientId),HttpStatus.OK);
    }

    @GetMapping("/disease")
    public ResponseEntity<?> getAllDisease(){
        return new ResponseEntity<>(diseaseRepo.findAll(),HttpStatus.OK);
    }

}
