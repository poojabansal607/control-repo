package com.sapient.assessment.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.sapient.assessment.dao.mapper.ProjectMapper;
import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.client.ProjectDetails;

public interface LoginDAO {
	//TODO: REMOVE THIS METHOD
	/*@SqlQuery("select projects.id,projects.name,projects.business_vertical,projects.dev_team_size,projects.qa_team_size,assessment.test_id from (select p.id, p.name, p.business_vertical, p.dev_team_size, p.qa_team_size, p.client_id, c.name as client_name from client_details as c INNER JOIN project_details as p on c.id=p.client_id AND c.username= :Username AND c.password= :Password) as projects LEFT JOIN assessment ON projects.id = assessment.project_id;")
	@Mapper(ProjectMapper.class)
	List<ProjectDetails> getLoginDetails(@Bind("Username")String username, @Bind("Password")String password);*/

	@SqlQuery("SELECT attrdetail.project_id, attrdetail.attribute_id,project_attribute.Name, attrdetail.sub_attribute_name, attrdetail.sub_attribute_value from project_attribute_details as attrdetail INNER JOIN project_attribute on attrdetail.attribute_id=project_attribute.id AND attrdetail.project_id= :Project_ID;")
	@Mapper(ProjectMapper.class)
	List<ProjectDetails> getProjectDetails(@Bind("Project_ID")long projectKey);

	@SqlQuery("Select project_details.id from project_details where project_details.client_id = :Client_ID")
	List<Long> getListofProjects(@Bind("Client_ID") long clientId);

	@SqlQuery("Select assessment.test_id from assessment where assessment.project_id = :Project_ID")
	long getassessmentIdofProject(@Bind("Project_ID") long projectId);

	@SqlQuery("Select name from project_details where id = :ProjectID")
	String getProjectName(@Bind("ProjectID") long projectID);




}
