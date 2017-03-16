package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Score {

	private final long clientId;
	private final long projectId;
	private final long questionId;
	
	public Score()
	{
		clientId=0;
		projectId=0;
		questionId=0;
	}
	
	
	
	public Score(long clientId,long projectId,long questionId)
	{
	
	this.clientId=clientId;
	this.projectId=projectId;
	this.questionId=questionId;
		
	}
	
	@JsonProperty
	public long getClientId() {
		return clientId;
	}
	@JsonProperty
	public long getProjectId() {
		return projectId;
	}
	@JsonProperty
	public long getQuestionId() {
		return questionId;
	}
	
}
