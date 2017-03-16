package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionKey {
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		QuestionKey other = (QuestionKey) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private long id;

    public QuestionKey() {
        // Jackson deserialization
    }

    public QuestionKey(long id) {
        this.id = id;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

}