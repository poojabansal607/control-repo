package com.sapient.assessment.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectKey {
    private long id;

    public ProjectKey() {
        // Jackson deserialization
    }

    public ProjectKey(long id, String name) {
        this.id = id;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

}