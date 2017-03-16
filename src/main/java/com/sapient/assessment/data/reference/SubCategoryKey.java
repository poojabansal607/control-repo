package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCategoryKey {
    private long id;

    public SubCategoryKey() {
        // Jackson deserialization
    }

    public SubCategoryKey(long id) {
        this.id = id;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

}