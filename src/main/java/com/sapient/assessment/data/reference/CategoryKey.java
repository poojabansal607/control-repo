package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryKey {
    private long id;

    public CategoryKey() {
        // Jackson deserialization
    }

    public CategoryKey(long id) {
        this.id = id;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

}