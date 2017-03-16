package com.sapient.assessment.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.reference.RootArea;
import com.sapient.assessment.service.AssessmentService;

@Path("/assessmentByName/{rootarea_name}")
@Produces(MediaType.APPLICATION_JSON)
public class NewRootAreaResource {
	private final AssessmentService assessmentService;

    public NewRootAreaResource(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GET
    @Timed
    public RootArea getAssessment(@PathParam("rootarea_name") String rootarea_name) {
    	
    	
        return assessmentService.getAssessmentDataByRootArea(rootarea_name);
    }
	
	
}

