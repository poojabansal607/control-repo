package com.sapient.assessment.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class ClientKey {
    private long id;

    public ClientKey() {
        // Jackson deserialization
    }

    public ClientKey(long id) {
        this.id = id;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

}