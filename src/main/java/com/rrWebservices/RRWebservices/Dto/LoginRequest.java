package com.rrWebservices.RRWebservices.Dto;

import java.time.LocalDateTime;

public class LoginRequest {
    private String username;
    private String password;
    
    // constructors, getters, and setters
    


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}

	

	
    
    // getters and setters for all fields (omitted for brevity)
}