package com.sapient.assessment.resources;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.client.ClientKey;
import com.sapient.assessment.data.client.ProjectKey;
import com.sapient.assessment.data.reference.LoginObject;
import com.sapient.assessment.service.LoginService;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {
	private final LoginService loginService;
	
	public LoginResource(LoginService loginService) {
        this.loginService = loginService;
    }

 	@POST
    @Timed
  
    public Client  check(LoginObject loginObject) throws URISyntaxException
 
    {	
 		
 		Client client_details = loginService.checkLoginDetails(loginObject.getUsername(), loginObject.getPassword());
 		System.out.println(client_details.getProjects() + "----------");
 		if(client_details!= null ){
			return client_details ; 			
 		}
 		else{
 			return new Client();
 	
 		}
 		
    	
    }
	
	
	
}
