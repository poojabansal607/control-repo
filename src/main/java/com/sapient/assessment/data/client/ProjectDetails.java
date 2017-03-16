package com.sapient.assessment.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectDetails {
	

	@JsonProperty
	private final long projectKey;
	@JsonProperty
	private final long attributeKey;
	@JsonProperty
	private final String attributeName;
	@JsonProperty
	private final String subAttributeName;
	@JsonProperty
	private final String subAttributeValue;

	public ProjectDetails() {
		this.projectKey = 0;
		this.attributeKey = 0;
		this.attributeName = null;
		this.subAttributeName = null;
		this.subAttributeValue = null;
	}


	public ProjectDetails(long projectKey, long attributeKey, String attributeName, String subAttributeName,
						  String subAttributeValue) {
		this.projectKey = projectKey;
		this.attributeKey = attributeKey;
		this.attributeName = attributeName;
		this.subAttributeName = subAttributeName;
		this.subAttributeValue = subAttributeValue;
	}

	public long getProjectKey() {
		return projectKey;
	}

	public long getAttributeKey() {
		return attributeKey;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public String getSubAttributeName() {
		return subAttributeName;
	}
	public String getSubAttributeValue() {
		return subAttributeValue;
	}

}
