package com.example.healthcareapi.service;


import com.example.healthcareapi.model.Appointment;
import com.example.healthcareapi.repos.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepo aRepo;

    @Autowired
    public AppointmentService(AppointmentRepo aRepo) {
        this.aRepo = aRepo;
    }

    public boolean registerAppoinment(Appointment appointment){
        aRepo.save(appointment);
        return true;
    }
    public boolean deleteAppoinment(long id){
        aRepo.deleteById(id);
        return true;
    }

    public List<Appointment> getAllAppoinments(){
        return aRepo.findAll();
    }

    public List<Appointment> getAllPatientAppoinment(long id){
        return aRepo.findAllByPatientId(id);
    }
}
