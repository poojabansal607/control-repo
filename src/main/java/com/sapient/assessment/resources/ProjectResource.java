package com.sapient.assessment.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.sapient.assessment.data.client.NewProject;
import com.sapient.assessment.data.client.Project;
import com.sapient.assessment.data.client.ProjectDetails;
import com.sapient.assessment.data.client.ProjectDetailsFormatted;
import com.sapient.assessment.service.ProjectService;

@Path("/project")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource {
    private final ProjectService projectService;

    public ProjectResource(ProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @Path("/Details/{project_key}")
    @POST
    @Timed
    public List<ProjectDetailsFormatted> getProjectDetails(@PathParam("project_key") long projectKey) {

        return projectService.getProjectDetails(projectKey);


    }

    //check how to send and receive two arguments
    @Path("/AddProject")
    @POST
    @Timed
    public Project addProject(NewProject newProject) {

       return projectService.saveProjectDetails(newProject);

       
    }

    @Path("/UpdateProject")
    @POST
    @Timed
    public boolean updateProject(List<ProjectDetails> projectDetails) {

        projectService.updateProjectDetails(projectDetails, projectDetails.get(0).getProjectKey());

        return true;
    }

    @Path("/CheckProject")
    @POST
    @Timed
    public List<ProjectDetails> checkProject() {
        return projectService.checkMethod(6);
    }

}
