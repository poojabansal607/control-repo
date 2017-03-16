package com.sapient.assessment.data.assessments;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sapient.assessment.data.client.ProjectKey;

public class ResponseAssessment {
	
	
	
	
	
	//Capture response of a given project
	
	@JsonProperty("ObjectFinal")
	private List<SubCatAssessment> subCat;
	@JsonProperty("projectId")
	private long projectId;
	
	public List<SubCatAssessment> getSubCat() {
		return subCat;
	}
	public void setSubCat(List<SubCatAssessment> subCat) {
		this.subCat = subCat;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	
	
	
}
