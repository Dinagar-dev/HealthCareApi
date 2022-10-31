package com.example.healthcareapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="appuserdetails")
public class AppUserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="username")
	private String user_name;
    private String password;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private UserProfileDetails userProfile;
//    @Column(name="usermobile")
//    private String user_mobile;
//    @Column(name="useremail")
//    private String user_email;
//    private String location;
    
    public AppUserDetails(String user_name,String password,UserProfileDetails userProfile) {
    	this.user_name=user_name;
    	this.password=password;
    	this.userProfile=userProfile;
    }
    
//    public AppUserDetails(String user_name,
//    		String password,
//    		String user_mobile,
//    		String user_email,
//    		String location) {
//    	
//    	this.user_name=user_name;
//    	this.password=password;
//    	this.user_email=user_email;
//    	this.user_mobile=user_mobile;
//    	this.location=location;
//    }
    
}
