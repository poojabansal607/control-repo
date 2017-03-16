package com.sapient.assessment.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectSubAttribute {
	
	
	
	public ProjectSubAttribute(String subAttributeName, String subAttributeValue) {
		
		this.subAttributeName = subAttributeName;
		this.subAttributeValue = subAttributeValue;
	}
	
	@JsonProperty
	private final String subAttributeName;
	@JsonProperty
	private final String subAttributeValue;
	
	

}
