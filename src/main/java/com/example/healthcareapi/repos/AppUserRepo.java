package com.example.healthcareapi.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.healthcareapi.model.AppUserDetails;

@Repository
public interface AppUserRepo extends JpaRepository<AppUserDetails, Long>{

	@Query(value="select * from appuserdetails where username=?1",nativeQuery=true)
	Optional<AppUserDetails> findByusername(String username);
}
