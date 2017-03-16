package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SubCategory {
    private final SubCategoryKey subCategoryKey;

    private final String name;

    private final List<Question> questions;
    
    private  String comments;
    @JsonProperty
    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	 @JsonProperty
	public String getMaturityLevel() {
		return maturityLevel;
	}

	public void setMaturityLevel(String maturityLevel) {
		this.maturityLevel = maturityLevel;
	}

	private  String maturityLevel;

    public SubCategory() {
        // Jackson deserialization
        questions = null;
        name = null;
        subCategoryKey = null;
        comments = null;
        maturityLevel = null;
    }

    public SubCategory(SubCategoryKey subCategoryKey, String name, List<Question> questions, String comments, String maturityLevel) {
        this.subCategoryKey = subCategoryKey;
        this.name = name;
        this.questions = questions;
        this.comments = comments;
        this.maturityLevel = maturityLevel;
    }

    @JsonProperty
    public SubCategoryKey getSubCategoryKey() {
        return subCategoryKey;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public List<Question> getQuestions() {
        return questions;
    }
}