package com.sapient.assessment.data.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import java.util.Collections;
import java.util.List;

public class Client {
    private final ClientKey clientKey;

   
   
    private final String name;
   
    private final String userName;
   
    private final String password;
   
    private final String email;
    @JsonProperty
    private final List<Project> projects;

    public Client() {
        // Jackson deserialization
        projects = Collections.EMPTY_LIST;
        name = null;
        clientKey = null;
        userName =null;
        password=null;
        email=null;
    }

    public Client(ClientKey clientKey, String name, String userName, String password, String email,
			List<Project> projects) {
		this.clientKey = clientKey;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.projects = projects;
	}

	

	
    @JsonProperty("Email")
    public String getEmail() {
		return email;
	}
    
    @JsonProperty("Username")
	public String getUserName() {
		return userName;
	}

    @JsonProperty("Password")
	public String getPassword() {
		return password;
	}

    @JsonProperty("Client_id")
    public ClientKey getClientKey() {
        return clientKey;
    }

    @JsonProperty("Client_name")
    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }
}