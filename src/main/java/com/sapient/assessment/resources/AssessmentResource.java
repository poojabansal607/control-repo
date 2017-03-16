package com.sapient.assessment.resources;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.assessments.ResponseAssessment;
import com.sapient.assessment.data.assessments.SubCatAssessment;

import com.sapient.assessment.data.reference.RootArea;
import com.sapient.assessment.data.reference.SubCategory;
import com.sapient.assessment.service.AssessmentService;
import com.sapient.assessment.service.ClientService;
import com.sapient.assessment.service.implementation.ClientServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/assessment/{project_key}")
@Produces(MediaType.APPLICATION_JSON)
public class AssessmentResource {
    private final AssessmentService assessmentService;

    public AssessmentResource(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GET
    @Timed
    public List<RootArea> getAssessment(@PathParam("project_key") long project_key) {
    	//TODO :implement this code
    	//assessmentService.beginAssessment(project_key);
        return assessmentService.getAssessmentData(project_key);
    }
    
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
     @POST
     @Timed
     public boolean save(ResponseAssessment response)
     {
     	//System.out.println(questions);
     	assessmentService.saveAssessmentData(response);
     	return true;
     }
    
}