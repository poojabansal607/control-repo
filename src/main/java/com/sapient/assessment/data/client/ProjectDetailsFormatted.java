package com.sapient.assessment.data.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectDetailsFormatted {


    @JsonProperty
    private final String attributeName;
    @JsonProperty
    private final List<ProjectSubAttribute> projectSubAttributeMapping;

    public ProjectDetailsFormatted(String attributeName,
                                   List<ProjectSubAttribute> projectSubAttributeMapping) {

        this.attributeName = attributeName;
        this.projectSubAttributeMapping = projectSubAttributeMapping;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public List<ProjectSubAttribute> getProjectSubAttributeMapping() {
        return projectSubAttributeMapping;
    }
}
