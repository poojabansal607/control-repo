package com.sapient.assessment.dao.mapper;

import com.sapient.assessment.data.reference.MaturityRating;
import com.sapient.assessment.data.reference.Question;
import com.sapient.assessment.data.reference.QuestionKey;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by djai10 on 10/4/2016.
 */
public class QuestionMapper implements ResultSetMapper<Question> {
    public Question map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Question(new QuestionKey(r.getLong("id")), r.getString("maturity_criteria"), MaturityRating.byId(r.getInt("maturity_level_score")));
    }
}
