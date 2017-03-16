package com.sapient.assessment.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.sapient.assessment.dao.mapper.ProjectMapper;
import com.sapient.assessment.data.client.ProjectDetails;

public interface ProjectDAO {
	
	@SqlUpdate("insert into project_attribute_details (project_id, attribute_id,sub_attribute_name,sub_attribute_value) values (:projectId,:attributeId,:subAttributeName,:subAttributeValue)")
	void saveProjectDetails(@Bind("projectId") long projectId, @Bind("attributeId") long attributeId, @Bind("subAttributeName") String subAttributeName, @Bind("subAttributeValue") String subAttributeValue);
	
	@SqlUpdate("Delete from project_attribute_details where project_id = :projectId")
	void deleteProjectDetails(@Bind("projectId") long projectId);
	
	
	@SqlQuery("Select id from project_details where client_id = :ClientId AND name = :ProjectName")
	Long getProjectIDfromName(@Bind("ClientId") long clientId,@Bind("ProjectName") String projectName);
	
	@SqlQuery("SELECT pad.project_id, pad.attribute_id,pa.Name, pad.sub_attribute_name, pad.sub_attribute_value from project_attribute_details as pad INNER JOIN project_attribute as pa on pad.attribute_id=pa.id AND pad.project_id= :Project_ID;")
	@Mapper(ProjectMapper.class)
	List<ProjectDetails> getProjectDetails(@Bind("Project_ID")long projectKey);
	
	@SqlQuery("Select id from project_attribute where Name = :attributeName")
	Long getAttributeId(@Bind("attributeName") String attributeName);
	
	@SqlUpdate("Update project_details set name = :ProjectName where id= :ProjectID ")
	void updateProjectName(@Bind("ProjectName") String projectName, @Bind("ProjectID") long projectId);
	
	@SqlUpdate("Insert into project_details (client_id,name) values (:ClientId, :Name)")
	void insertProject(@Bind("ClientId") long clientId, @Bind("Name") String name);
	
	@SqlUpdate("Update project_attribute_details set sub_attribute_value = :SubAttributeValue where project_id = :ProjectId AND attribute_id = :attributeID AND sub_attribute_name = :SubAttributeName")
	void updateProjectDetails(@Bind("SubAttributeValue") String subAttributeValue, @Bind("ProjectId") long projectId, @Bind("attributeID") long attributeId, @Bind("SubAttributeName") String subAttributeName);
	
	@SqlQuery("Select assessment.test_id from assessment where assessment.project_id = :Project_ID")
	long getassessmentIdofProject(@Bind("Project_ID") long projectId);
	
	@SqlQuery("Select name from project_details where id = :ProjectID")
	String getProjectName(@Bind("ProjectID") long projectID);
	
	
}
