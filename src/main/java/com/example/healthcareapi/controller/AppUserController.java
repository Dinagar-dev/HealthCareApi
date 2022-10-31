package com.example.healthcareapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthcareapi.model.AppUserDetails;
import com.example.healthcareapi.model.ResponseMessage;
import com.example.healthcareapi.model.UserProfileDetails;
import com.example.healthcareapi.securityconfigs.JwtHelper;
//import com.example.healthcareapi.service.AppUserProfileService;
import com.example.healthcareapi.service.AppUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppUserController {
	
	private boolean flg;
	private String message;
	private HttpStatus statusCode;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	AuthenticationManager authManager;
	
//	@Autowired
//	private AppUserProfileService appProfileService;
	
	@Autowired
	JwtHelper jwtHelper;

	@PostMapping("/register")
	public ResponseEntity<?> doRegister(@RequestBody AppUserDetails appUserDetails,
			@RequestBody UserProfileDetails userProfile ){
		flg=appUserService.doRegister(appUserDetails);
		message = flg?"Successful":"Failed";
		statusCode = flg?HttpStatus.OK:HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(new ResponseMessage(message),statusCode);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> doSignin(@RequestBody AppUserDetails appUserDetails){
		try {
			authManager.
			authenticate(new UsernamePasswordAuthenticationToken(
					appUserDetails.getUser_name(),
					appUserDetails.getPassword()));
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("authentication failed, Incorrect userName or password",HttpStatus.OK);
		}
		AppUserDetails currentUser=appUserService.getByUsername(appUserDetails.getUser_name());
		String token = jwtHelper.geratejwtToken(currentUser.getUser_name());
		String id =String.valueOf(currentUser.getId());
		log.info("token : {}ho",token);
		return new ResponseEntity<>(new ResponseMessage(id,token),HttpStatus.OK);
		
	}
	
	@PostMapping("/default")
	public ResponseEntity<?> onLogoutSuccessfull(){
		return new ResponseEntity<>(new ResponseMessage("Logged off successfully.."),HttpStatus.OK);
	}
	
	
	@GetMapping("/viewprofile/{id}")
	public ResponseEntity<?> getUserProfile(@PathVariable("id") String id){
		AppUserDetails appUsers = appUserService.getByUserId(Long.parseLong(id));
//		UserProfileDetails appUsers=appProfileService.getProfile(id);
		return new ResponseEntity<>(appUsers.getUserProfile(),appUsers!=null?HttpStatus.OK:HttpStatus.NOT_FOUND);
	}

	@PutMapping("/editprofile/{id}")
	public ResponseEntity<?> updateProfile(@PathVariable("id") String id,@RequestBody UserProfileDetails userDetails){
		appUserService.updateProfile(Long.parseLong(id), userDetails);
		return new ResponseEntity<>(new ResponseMessage("profile Updated"),HttpStatus.OK);
	}
	
}

