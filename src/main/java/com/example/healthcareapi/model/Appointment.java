package com.example.healthcareapi.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor
public class Appointment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String disease;
    private String priority;
    private Date creationDate;
    private long patientid;

    public Appointment(String disease, String priority, Date creationDate, long patientid) {
        this.disease = disease;
        this.priority = priority;
        this.creationDate = creationDate;
        this.patientid = patientid;
    }
}
