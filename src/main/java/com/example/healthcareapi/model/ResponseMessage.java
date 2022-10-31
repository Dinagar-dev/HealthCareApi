package com.example.healthcareapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class ResponseMessage {

	private String message;
	private String id;
	private String token;
	
	public ResponseMessage(String id,String token) {
		this.id=id;
		this.token=token;
	}
	
	public ResponseMessage(String message) {
		this.message=message;
	}
}
