package com.sapient.assessment.service;

import java.util.List;

import com.sapient.assessment.data.client.NewProject;
import com.sapient.assessment.data.client.Project;
import com.sapient.assessment.data.client.ProjectDetails;
import com.sapient.assessment.data.client.ProjectDetailsFormatted;

public interface ProjectService {

   Project saveProjectDetails(NewProject newProject);

    void updateProjectDetails(List<ProjectDetails> projectDetails, long projectId);

    List<ProjectDetailsFormatted> getProjectDetails(long projectId);

    List<ProjectDetails> checkMethod(long projectId);


}
