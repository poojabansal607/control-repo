package com.sapient.assessment.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.client.ClientKey;
import com.sapient.assessment.data.client.ProjectKey;
import com.sapient.assessment.data.client.ProjectDetails;
import com.sapient.assessment.data.reference.Category;
import com.sapient.assessment.data.reference.CategoryKey;
import com.sapient.assessment.data.reference.SubCategory;

public class ProjectMapper implements ResultSetMapper<ProjectDetails> {

	public ProjectDetails map(int arg0, ResultSet r, StatementContext s) throws SQLException {
		
		return  new ProjectDetails(r.getLong("project_id"),r.getLong("attribute_id"), r.getString("Name"), r.getString("sub_attribute_name"), r.getString("sub_attribute_value"));
    
	}

}
