package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionAssessment {
	@JsonProperty
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
