package com.sapient.assessment.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.sapient.assessment.data.reference.MaturityRating;
import com.sapient.assessment.data.reference.Question;
import com.sapient.assessment.data.reference.QuestionKey;

public class ResponseMapper implements ResultSetMapper<Question> {

	public Question map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		 return new Question(new QuestionKey(r.getLong("question_id")));

	}

}
