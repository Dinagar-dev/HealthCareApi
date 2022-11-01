package com.example.healthcareapi.controller;


import com.example.healthcareapi.model.Appointment;
import com.example.healthcareapi.model.ResponseMessage;
import com.example.healthcareapi.service.AppUserService;
import com.example.healthcareapi.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController()
@RequestMapping("/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> appoinmentRegistration(@RequestBody Appointment appoinment){
        appointmentService.registerAppoinment(appoinment);
        return new ResponseEntity<>(new ResponseMessage("Registered Successfully"), OK);
    }

    @GetMapping("/list/{pId}")
    public ResponseEntity<?> getPatientAppointmentList(@PathVariable("pId") long id){
        return new ResponseEntity<>(appointmentService.getAllPatientAppoinment(id),OK);
    }

    @DeleteMapping("/delete/{aId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("aId") long id){
        return new ResponseEntity<>(appointmentService.deleteAppoinment(id),OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllApointments(){
        return new ResponseEntity<>(appointmentService.getAllAppoinments(),OK);
    }
}
