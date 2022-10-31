package com.example.healthcareapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
	CommandLineRunner runner(AppUserRepo repo,AppUserProfileRepo profileRepo) {
		return args->{
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			UserProfileDetails details=new UserProfileDetails("dinagar","+919876543210","testEmail@gmail.com","India");
			AppUserDetails uDetails = new AppUserDetails("dinagar",encoder.encode("password"),details);
			repo.save(uDetails);
//			profileRepo.save();
			
		};
	}

}
