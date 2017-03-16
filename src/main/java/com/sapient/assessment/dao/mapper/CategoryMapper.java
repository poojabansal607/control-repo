package com.sapient.assessment.dao.mapper;

import com.sapient.assessment.data.reference.Category;
import com.sapient.assessment.data.reference.CategoryKey;
import com.sapient.assessment.data.reference.SubCategory;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

/**
 * Created by djai10 on 10/4/2016.
 */
public class CategoryMapper implements ResultSetMapper<Category> {
    public Category map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Category(new CategoryKey(r.getLong("id")), r.getString("name"), Collections.<SubCategory>emptyList());
    }
}
