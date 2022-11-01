package com.example.healthcareapi.controller;


import com.example.healthcareapi.model.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController("/appointment")
public class AppointmentController {

    @PostMapping("/register")
    public ResponseEntity<?> appoinmentRegistration(@RequestBody Appointment appoinment){
        return new ResponseEntity<>("", OK);
    }

    @GetMapping("/list/{pId}")
    public ResponseEntity<?> getPatientAppointmentList(@PathVariable("pId") long id){
        return new ResponseEntity<>("",OK);
    }

    @DeleteMapping("/delete/{aId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("aId") long id){
        return new ResponseEntity<>("",OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllApointments(){
        return new ResponseEntity<>("",OK);
    }
}
