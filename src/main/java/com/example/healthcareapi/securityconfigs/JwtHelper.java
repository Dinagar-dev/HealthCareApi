package com.example.healthcareapi.securityconfigs;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;



@Component
public class JwtHelper {
	
	private final RSAPrivateKey privateKey;
	private final RSAPublicKey publicKey;
	
	private static final int EXPIRYTIME=1000*60*60;
	
	public JwtHelper(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}
	
	public String geratejwtToken(String subject) {
		
		JWTCreator.Builder jwtBuilder = JWT.create().withSubject(subject);
		
		return jwtBuilder
				.withIssuedAt(new Date(System.currentTimeMillis()))
				.withExpiresAt(new Date(System.currentTimeMillis()+EXPIRYTIME))
				.sign(Algorithm.RSA256(publicKey, privateKey));
	}

}

