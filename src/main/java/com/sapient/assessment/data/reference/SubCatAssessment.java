package com.sapient.assessment.data.reference;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCatAssessment {
	
	
	public List<Long> getCheckedQuestion() {
		return checkedQuestion;
	}
	public void setCheckedQuestion(List<Long> checkedQuestion) {
		this.checkedQuestion = checkedQuestion;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getMaturityLevel() {
		return maturityLevel;
	}
	public void setMaturityLevel(String maturityLevel) {
		this.maturityLevel = maturityLevel;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	 @JsonProperty("listOfselectedQuestions")
	private List<Long> checkedQuestion = new ArrayList<Long>();
	 
	 @JsonProperty("Comments")
	private String comments;
	 
	@JsonProperty("MaturityLevel")
	private String maturityLevel;
	
	@JsonProperty("SubCategoryID")
	private long id;
	
	@JsonProperty("subCategoryName")
	private String name;
	
	
}
