package com.sapient.assessment.data.assessments;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sapient.assessment.data.reference.QuestionKey;

import java.util.List;

public class QuestionAssessment {

    private final QuestionKey questionKey;
    private final boolean selected;

    public QuestionAssessment() {
        // Jackson deserialization
        questionKey = null;
        selected = false;
    }

    public QuestionAssessment(QuestionKey questionKey, boolean selected, List<QuestionAssessment> questionAssessments) {
        this.questionKey = questionKey;
        this.selected = selected;
    }


    @JsonProperty
    public QuestionKey getQuestionKey() {
        return questionKey;
    }

    @JsonProperty
    public boolean isSelected() {
        return selected;
    }
}