package com.sapient.assessment.resources;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.assessments.ResponseAssessment;
import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.service.AssessmentService;
import com.sapient.assessment.service.ClientService;
import com.sapient.assessment.service.implementation.ClientServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {
    private final ClientService clientService;
  

    public ClientResource(ClientServiceImpl clientService) {
        this.clientService = clientService;
      
    }

    @GET
    @Timed
    public List<Client> getClients(@QueryParam("name") Optional<String> name, @QueryParam("id") Optional<String> id) {
        return clientService.getClients(name.orElse(""));
    }
    
    @Path("/saveAssessment")
    @POST 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String saveAssessment(String a){
    	System.out.println(a);
    	return "hello";
    }
    
    
   
    
}