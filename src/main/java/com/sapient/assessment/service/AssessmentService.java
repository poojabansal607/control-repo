package com.sapient.assessment.service;

import com.sapient.assessment.data.assessments.ResponseAssessment;
import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.reference.Question;
import com.sapient.assessment.data.reference.RootArea;

import java.util.List;

/**
 * Created by djai10 on 10/4/2016.
 */
public interface AssessmentService {
    List<RootArea> getAssessmentData(long project_key);
    
       void saveAssessmentData(ResponseAssessment response);

	RootArea getAssessmentDataByRootArea(String string);
	List<Question> getQuestionBySubCat(long project_id, String subcat_name);
	void beginAssessment(long projectKey);
	long getTestId(long projectKey);
	void deleteAssessmentData (long testId);
}
