package com.sapient.assessment.data.assessments;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestJson {
	
	@JsonProperty
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@JsonProperty
	private String city;
	
	
}
