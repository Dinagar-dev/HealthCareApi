package com.example.healthcareapi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.healthcareapi.model.AppUserDetails;
import com.example.healthcareapi.model.UserProfileDetails;
import com.example.healthcareapi.repos.AppUserProfileRepo;
import com.example.healthcareapi.repos.AppUserRepo;

@Service
public class AppUserService implements UserDetailsService{
	
	@Autowired
	PasswordEncoder encoder;

	private AppUserDetails currentUser;
	@Autowired
	private AppUserRepo appRepo;
	
	@Autowired
	private AppUserProfileRepo profileRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		currentUser=getByUsername(username);
		 return new User(currentUser.getUser_name(),currentUser.getPassword(),new ArrayList<>());
	}
	
	public boolean doRegister(AppUserDetails appUserDetails) {
		if((getByUsername(appUserDetails.getUser_name()))!=null) {
			return false;
		}
		String enCodedPassword=encoder.encode(appUserDetails.getPassword());
		appUserDetails.setPassword(enCodedPassword);
		appRepo.save(appUserDetails);
		return true;
	}
	
	public AppUserDetails getByUsername(String username) {
		Optional<AppUserDetails> user=appRepo.findByusername(username);
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
	public AppUserDetails getByUserId(Long id) {
		return appRepo.findById(id).get();
	}
	
	public boolean updateProfile(Long id, UserProfileDetails profileDetails) {
		AppUserDetails userDetails=appRepo.findById(id).get();
		UserProfileDetails proDetails=profileRepo.findById(id).get();
		proDetails.update(profileDetails);
		appRepo.save(userDetails);
		return true;
	}
	
}
