package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private final QuestionKey questionKey;
    @JsonProperty
    private long id;
  
    private final String name;

    private final MaturityRating maturityRating;
    
    private boolean isChecked;

    @JsonProperty
    public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public Question() {
        // Jackson deserialization
        name = null;
        questionKey = null;
        maturityRating = null;
        isChecked= (Boolean) null;
    }

    public Question(QuestionKey questionKey, String name, MaturityRating maturityRating) {
        this.questionKey = questionKey;
        this.name = name;
        this.maturityRating = maturityRating;
        this.isChecked=false;
    }

    public Question(QuestionKey questionKey) {
    	this.questionKey=questionKey;
    	 this.name = null;
         this.maturityRating = null;
         this.isChecked=true;
		// TODO Auto-generated constructor stub
	}

	@JsonProperty
    public QuestionKey getQuestionKey() {
        return questionKey;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionKey == null) ? 0 : questionKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (questionKey == null) {
			if (other.questionKey != null)
				return false;
		} else if (!questionKey.equals(other.questionKey))
			return false;
		return true;
	}

	@JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public MaturityRating getMaturityRating() {
        return maturityRating;
    }
   
}