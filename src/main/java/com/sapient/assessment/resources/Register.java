package com.sapient.assessment.resources;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.client.Client;

import com.sapient.assessment.service.RegisterService;

@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Register {
	private final RegisterService registerService;

	public Register(RegisterService registerService) {
		this.registerService = registerService;
		// TODO Auto-generated constructor stub
	}

	@POST
	@Timed

	public long check(String name) throws URISyntaxException

	{
		long existUserName = registerService.checkUserName(name);
		System.out.println("REGISTER USERNAME" + existUserName);
		if (existUserName == 1) {
			return 1;
		} else {
			return 0;
		}

	}

	@Path("/save")
	@POST
	@Timed
	public String save(Client clientDetails) {

		System.out.println(clientDetails.getUserName());
		registerService.saveClientDetails(clientDetails.getName(), clientDetails.getUserName(),
				clientDetails.getPassword(), clientDetails.getEmail());
		return "success";

	}

	@POST
	@Path("/clientName")
	@Timed
	public long checkClientName(String name) throws URISyntaxException

	{
		long existClientName = registerService.checkClientName(name);
		System.out.println("REGISTER CLIENTNAME" + existClientName);
		if (existClientName == 1) {
			return 1;
		} else {
			return 0;
		}

	}

	@POST
	@Path("/email")
	@Timed
	public long checkEmail(String name) throws URISyntaxException

	{
		long existEmailId = registerService.checkEmailId(name);
		System.out.println("REGISTER EMAILID" + existEmailId);
		if (existEmailId == 1) {
			return 1;
		} else {
			return 0;
		}

	}

}