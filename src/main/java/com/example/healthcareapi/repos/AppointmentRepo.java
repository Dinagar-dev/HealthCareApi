package com.example.healthcareapi.repos;


import com.example.healthcareapi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

    @Query(value = "select * from appoinment where patientid=?1",nativeQuery = true)
    List<Appointment> findAllByPatientId(long pId);


}
