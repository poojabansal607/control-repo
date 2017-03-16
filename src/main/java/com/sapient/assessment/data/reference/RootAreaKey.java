package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootAreaKey {
    private long id;

    public RootAreaKey() {
        // Jackson deserialization
    }

    public RootAreaKey(long id) {
        this.id = id;
    }


    @JsonProperty
    public long getId() {
        return id;
    }

}