package com.example.healthcareapi;

import com.example.healthcareapi.model.Patients;
import com.example.healthcareapi.repos.PatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.healthcareapi.model.AppUserDetails;
import com.example.healthcareapi.model.UserProfileDetails;
import com.example.healthcareapi.repos.AppUserProfileRepo;
import com.example.healthcareapi.repos.AppUserRepo;

@SpringBootApplication
public class HealthcareapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareapiApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(AppUserRepo repo, AppUserProfileRepo profileRepo, PatientRepo patientRepo) {
		return args->{
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			UserProfileDetails details=new UserProfileDetails("dinagar","+919876543210","testEmail@gmail.com","India");
			AppUserDetails uDetails = new AppUserDetails("dinagar",encoder.encode("password"),details);
			repo.save(uDetails);
			patientRepo.save(new Patients((long)1,"patient1","male","09-02-2000",
					"+918887643132","patient1@gmail.com","fever"));

			patientRepo.save(new Patients((long)1,"patient2","male","09-02-2000",
					"+918987643132","patient2@gmail.com","headache"));

			patientRepo.save(new Patients((long)1,"patient3","female","09-02-2000",
					"+918987643132","patient3@gmail.com","cold"));
//			profileRepo.save();
			
		};
	}

}
