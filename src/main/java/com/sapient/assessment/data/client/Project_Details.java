package com.sapient.assessment.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project_Details {
	public Project_Details(ProjectKey id, String name, String businessVertical, long devTeamSize, long qaTeamSize) {
		this.id = id;
		this.name = name;
		this.businessVertical = businessVertical;
		this.devTeamSize = devTeamSize;
		this.qaTeamSize = qaTeamSize;
		
	}
	
	@JsonProperty("project_id")
	private  ProjectKey id;
	@JsonProperty("projectName")
	private final  String name;
	@JsonProperty("buisnessVertical")
	private final String businessVertical;
	@JsonProperty("devTeamSize")
	private final long devTeamSize;
	@JsonProperty("qaTeamSize")
	private final long qaTeamSize;
	
	
	public ProjectKey getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public String getBusinessVertical() {
		return businessVertical;
	}
	
	public long getDevTeamSize() {
		return devTeamSize;
	}
	
	public long getQaTeamSize() {
		return qaTeamSize;
	}
	
	
	
	
	

}

