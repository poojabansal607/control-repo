package com.sapient.assessment.data.assessments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sapient.assessment.data.reference.MaturityRating;
import com.sapient.assessment.data.reference.SubCategoryKey;

import java.util.List;

public class SubCategoryAssessment {

    private final SubCategoryKey subCategoryKey;
    private final String comment;
    private final MaturityRating evaluatedRating;
    private final MaturityRating recommendedRating;

    private final List<QuestionAssessment> questionAssessments;

    public SubCategoryAssessment() {
        // Jackson deserialization
        subCategoryKey = null;
        comment = null;
        evaluatedRating = null;
        recommendedRating = null;
        questionAssessments = null;
    }

    public SubCategoryAssessment(SubCategoryKey subCategoryKey, String comment, MaturityRating evaluatedRating, MaturityRating recommendedRating, List<QuestionAssessment> questionAssessments) {
        this.subCategoryKey = subCategoryKey;
        this.comment = comment;
        this.evaluatedRating = evaluatedRating;
        this.recommendedRating = recommendedRating;
        this.questionAssessments = questionAssessments;
    }

    @JsonProperty
    public SubCategoryKey getSubCategoryKey() {
        return subCategoryKey;
    }

    @JsonProperty
    public String getComment() {
        return comment;
    }

    @JsonProperty
    public MaturityRating getEvaluatedRating() {
        return evaluatedRating;
    }

    @JsonProperty
    public MaturityRating getRecommendedRating() {
        return recommendedRating;
    }

    @JsonProperty
    public List<QuestionAssessment> getQuestionAssessments() {
        return questionAssessments;
    }
}