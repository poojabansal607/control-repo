package com.sapient.assessment.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.assessments.TestJson;

@Path("/JsonConsumption")
@Produces("text/plain")
@Consumes(MediaType.APPLICATION_JSON)
public class JsonConsumption {

	 	@POST
	    @Timed
	    public String save(TestJson jsonObject)
	    {
	 		System.out.println(jsonObject.getCity()+"   "+jsonObject.getName());
	 		return "200";
	    	
	    }
	
	
	
	
	
	
	
	
	
}
