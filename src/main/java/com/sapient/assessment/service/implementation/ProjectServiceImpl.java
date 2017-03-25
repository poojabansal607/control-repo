package com.sapient.assessment.service.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sapient.assessment.dao.ProjectDAO;
import com.sapient.assessment.data.client.NewProject;
import com.sapient.assessment.data.client.Project;
import com.sapient.assessment.data.client.ProjectDetails;
import com.sapient.assessment.data.client.ProjectDetailsFormatted;
import com.sapient.assessment.data.client.ProjectSubAttribute;
import com.sapient.assessment.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	private final ProjectDAO projectDAO;

	public ProjectServiceImpl(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	//Check batch insert
	public Project saveProjectDetails(NewProject newProject) {
		String applicationName = null;

		for (ProjectDetails project : newProject.getProjectDetails()) {

			if (project.getSubAttributeName().equals("Application Name")) {

				applicationName = project.getSubAttributeValue();
			}
		}
		projectDAO.insertProject(newProject.getClientID(), applicationName);
		long projectId = projectDAO.getProjectIDfromName(newProject.getClientID(), applicationName);
		for (ProjectDetails project : newProject.getProjectDetails()) {
			Long attributeId = projectDAO.getAttributeId(project.getAttributeName());
			projectDAO.saveProjectDetails(projectId, attributeId, project.getSubAttributeName(),
					project.getSubAttributeValue());

		}
		long testId = projectDAO.getassessmentIdofProject(projectId);
		return new Project (projectId,testId,applicationName);
	}

	/**
	 *
	 * @param projectDetails
	 * @param projectId
	 *
	 * 1. you have the projectId
	 * 2. Flush out the current project details from DB
	 * 3. and write the updated project details to DB.
     */
	public void updateProjectDetails(List<ProjectDetails> projectDetails, long projectId) {
		String applicationName = null;
		long projectID = 0;
		for (ProjectDetails project : projectDetails) {

			// Find the updated Project Name from the list
			if (project.getSubAttributeName().equals("Application Name")) {

				applicationName = project.getSubAttributeValue();
				projectID = project.getProjectKey();
			}

			Long attributeId = projectDAO.getAttributeId(project.getAttributeName());
			projectDAO.updateProjectDetails(project.getSubAttributeValue(), project.getProjectKey(), attributeId,
					project.getSubAttributeName());

		}
		// Set the updated project Name
		projectDAO.updateProjectName(applicationName, projectID);
	}

	public List<ProjectDetailsFormatted> getProjectDetails(long projectId) {

		List<ProjectDetails> projectDetails = projectDAO.getProjectDetails(projectId);

		HashMap<String, List<ProjectSubAttribute>> projectAttributeMapping = new HashMap<String, List<ProjectSubAttribute>>();

		for (ProjectDetails projectDetail : projectDetails) {

			if(!projectAttributeMapping.containsKey(projectDetail.getAttributeName())){
				projectAttributeMapping.put(projectDetail.getAttributeName(), new ArrayList<ProjectSubAttribute>());
			}
			List<ProjectSubAttribute> projectSubAttributes = projectAttributeMapping.get(projectDetail.getAttributeName());
			projectSubAttributes.add(new ProjectSubAttribute(projectDetail.getSubAttributeName(), projectDetail.getSubAttributeValue()));
		}


		List<ProjectDetailsFormatted> projectDetailsFormatted = new ArrayList<ProjectDetailsFormatted>();
		for (String key : projectAttributeMapping.keySet()) {
			projectDetailsFormatted.add(new ProjectDetailsFormatted(key, projectAttributeMapping.get(key)));
		}

		return projectDetailsFormatted;

	}

	public List<ProjectDetails> checkMethod(long projectId) {
		return projectDAO.getProjectDetails(projectId);
	}



}
