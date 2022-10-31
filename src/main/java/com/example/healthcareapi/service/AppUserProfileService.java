package com.example.healthcareapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcareapi.model.UserProfileDetails;
import com.example.healthcareapi.repos.AppUserProfileRepo;

@Service
public class AppUserProfileService {

	@Autowired
	private AppUserProfileRepo profileRepo;
	
	
	public UserProfileDetails getProfile(Long id) {
		return profileRepo.findById(id).get();
	}
}
