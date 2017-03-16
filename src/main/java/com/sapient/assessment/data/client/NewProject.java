package com.sapient.assessment.data.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewProject {

    @JsonProperty
    private final long clientID;
    @JsonProperty
    private final List<ProjectDetails> projectDetails;


    public NewProject() {
        this.clientID = 0;
        this.projectDetails = null;
    }


    public NewProject(long clientID, List<ProjectDetails> projectDetails) {
        super();
        this.clientID = clientID;
        this.projectDetails = projectDetails;
    }


    public long getClientID() {
        return clientID;
    }


    public List<ProjectDetails> getProjectDetails() {
        return projectDetails;
    }

}
