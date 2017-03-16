package com.sapient.assessment.data.assessments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sapient.assessment.data.client.ProjectKey;

import java.util.List;

public class Assessment {
    private final ProjectKey projectKey;

    private final List<SubCategoryAssessment> subCategoryAssessments;

    public Assessment() {
        // Jackson deserialization
        subCategoryAssessments = null;
        projectKey = null;
    }

    public Assessment(ProjectKey projectKey, List<SubCategoryAssessment> subCategoryAssessments) {
        this.projectKey = projectKey;
        this.subCategoryAssessments = subCategoryAssessments;
    }

    @JsonProperty
    public ProjectKey getProjectKey() {
        return projectKey;
    }

    @JsonProperty
    public List<SubCategoryAssessment> getSubCategoryAssessments() {
        return subCategoryAssessments;
    }
}