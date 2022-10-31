package com.example.healthcareapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.healthcareapi.model.UserProfileDetails;

@Repository
public interface AppUserProfileRepo extends JpaRepository<UserProfileDetails,Long>{

//	Optional<UserProfileDetails> findByUserId(Long id);
}
