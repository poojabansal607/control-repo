package com.sapient.assessment.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.sapient.assessment.dao.ClientDao;
import com.sapient.assessment.dao.LoginDAO;
import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.client.Project;

import com.sapient.assessment.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private final LoginDAO loginDAO;
	private final ClientDao clientDAO;

	public LoginServiceImpl(LoginDAO loginDAO, ClientDao clientDAO) {
		this.clientDAO = clientDAO;
		this.loginDAO = loginDAO;
	}

	public Client checkLoginDetails(String username, String password) {
		Client loggedInClient = clientDAO.getClientDetails(username, password);
		if (loggedInClient == null) {
			return new Client();
		} else {
			List<Project> projects = getProjectData(loggedInClient);
			Client client = new Client(loggedInClient.getClientKey(), loggedInClient.getName(),
					loggedInClient.getUserName(), loggedInClient.getPassword(), loggedInClient.getEmail(), projects);
			return client;
		}

	}

	public List<Project> getProjectData(Client client) {
		// List of all projects for the client
		List<Project> projects = new ArrayList<Project>();

		// Get id's of all the project for the respective clientID
		List<Long> listOfProjectId = loginDAO.getListofProjects(client.getClientKey().getId());

		// Get Details of all the projects by iterating through the list and consolidating the data


		//Consolidate details of every project one at a time
		for (Long projectId : listOfProjectId) {
			//Get the assessment ID of the project if it exists
			long testId = loginDAO.getassessmentIdofProject(projectId);

			//Get the project name
			String projectName = loginDAO.getProjectName(projectId);


			//Create the Final Project Object and add to the List of Projects of the Client
			Project project = new Project(projectId, testId,projectName);
			projects.add(project);

		}

		return projects;

	}

}
