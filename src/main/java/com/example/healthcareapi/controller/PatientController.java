package com.example.healthcareapi.controller;

import com.example.healthcareapi.model.Patients;
import com.example.healthcareapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private PatientService patientService;
    @Autowired
    PatientController(PatientService patientService){
        this.patientService=patientService;
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
}
