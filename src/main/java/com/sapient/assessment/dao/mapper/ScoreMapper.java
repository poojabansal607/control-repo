package com.sapient.assessment.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.sapient.assessment.data.reference.Question;
import com.sapient.assessment.data.reference.Score;

public class ScoreMapper implements ResultSetMapper<Score>{

	
	public Score map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		return new Score( r.getLong("clientId"), r.getLong("projectId"), r.getLong("questionId"));
	}

}
