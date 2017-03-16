package com.sapient.assessment.data.client;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

	
	
	@JsonProperty("project_id")
	private final long projectID;
	
	public Project(long projectID, long testId,String projectName) {
		super();
		this.projectID = projectID;
		this.testId = testId;
		this.projectName = projectName;
	}
	@JsonProperty
	private final long testId;
	@JsonProperty
	private final String projectName;
	
	
}
