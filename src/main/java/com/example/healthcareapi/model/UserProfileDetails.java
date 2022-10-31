package com.example.healthcareapi.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
public class UserProfileDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
//    private Long userId;
	private String user_name;
	private String user_mobile;
//    @Column(name="useremail")
    private String user_email;
    private String location;
    
    
	public UserProfileDetails(String user_name, String user_mobile, String user_email, String location) {
//		super();
		this.user_name = user_name;
		this.user_mobile = user_mobile;
		this.user_email = user_email;
		this.location = location;
	}
    
	public void update(UserProfileDetails profileDetails) {
		String name=profileDetails.getUser_name();
		String email=profileDetails.getUser_email();
		String mobile=profileDetails.getUser_mobile();
		String location=profileDetails.getLocation();
		if(name!=null) {
			this.setUser_name(name);
		}
		if(email!=null) {
			this.setUser_email(email);
		}
		if(mobile!=null) {
			this.setUser_mobile(mobile);
		}
		if(location!=null) {
			this.setLocation(location);
		}
	}
    

}
