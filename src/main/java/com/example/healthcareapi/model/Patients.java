package com.example.healthcareapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Patients {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long patientid;
	private String patient_name;
	private String patient_gender; 
	private Date patient_dob;
    private String patient_mobile;
    private String patient_email;
//    private String desc;
    
	public Patients(String patient_name, String patient_gender, Date patient_dob, String patient_mobile,
			String patient_email/*, String desc*/) {
		

		this.patient_name = patient_name;
		this.patient_gender = patient_gender;
		this.patient_dob = patient_dob;
		this.patient_mobile = patient_mobile;
		this.patient_email = patient_email;
//		this.desc = desc;
	}


    
    
}
