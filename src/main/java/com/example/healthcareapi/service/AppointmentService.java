package com.example.healthcareapi.service;


import com.example.healthcareapi.model.Appointment;
import com.example.healthcareapi.repos.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepo aRepo;
    private PatientService patientService;


    @Autowired
    public AppointmentService(AppointmentRepo aRepo,PatientService patientService) {
        this.aRepo = aRepo;
        this.patientService=patientService;
    }

    public boolean registerAppoinment(Appointment appointment){

        if(patientService.getSinglePatient(appointment.getPatientid())!=null){
            aRepo.save(appointment);
            return true;
        }

        return false;
    }
    public boolean deleteAppoinment(long id){

        if(aRepo.findById(id).orElse(null)!=null){
            aRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Appointment> getAllAppoinments(){
        return aRepo.findAll();
    }

    public List<Appointment> getAllPatientAppoinment(long id){
        return aRepo.findAllByPatientId(id);
    }


}
