package com.sapient.assessment.data.reference;



import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginObject {
	
	
	/*@JsonProperty("name")
	private String name;
	@JsonProperty("SapientId")
	private long s_id;*/
	
	
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
	@JsonProperty("name")
	private String username;
	@JsonProperty("password")
	private String password;
	
	
	
	
	

}
