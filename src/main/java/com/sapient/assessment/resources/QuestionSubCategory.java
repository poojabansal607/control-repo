package com.sapient.assessment.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.reference.Question;
import com.sapient.assessment.data.reference.RootArea;
import com.sapient.assessment.service.AssessmentService;

@Path("/{rootarea_name}/{category_name}/{subcat_name}/{project_key}")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionSubCategory {
	private final AssessmentService assessmentService;

	public QuestionSubCategory(AssessmentService assessmentService) {
		this.assessmentService = assessmentService;
	}
	
	@GET
    @Timed
    public List<Question> getQuestionBySubCat(@PathParam("subcat_name") String subcat_name,@PathParam("project_key") long project_id) {
		
        return assessmentService.getQuestionBySubCat(project_id,subcat_name);
    }

}
