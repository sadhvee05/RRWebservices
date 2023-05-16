package com.rrWebservices.RRWebservices.Dto;

import java.time.LocalDateTime;

public class LoginRequestModel {
    private String username;
    private Long roleId;
    private String createdOn;
    private String token;
    boolean isError;
    
    // constructors, getters, and setters


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public boolean isError() {
		return isError;
	}


	public void setError(boolean isError) {
		this.isError = isError;
	}


	@Override
	public String toString() {
		return "LoginRequestModel [username=" + username + ", roleId=" + roleId + ", createdOn=" + createdOn
				+ ", token=" + token + ", isError=" + isError + "]";
	}


	
    
    // getters and setters for all fields (omitted for brevity)
}
