package com.sapient.assessment.dao.mapper;

import com.sapient.assessment.data.reference.SubCategory;
import com.sapient.assessment.data.reference.SubCategoryKey;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

/**
 * Created by djai10 on 10/4/2016.
 */
public class SubCategoryMapper implements ResultSetMapper<SubCategory> {
    public SubCategory map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new SubCategory(new SubCategoryKey(r.getLong("id")), r.getString("sub_category_name"), Collections.EMPTY_LIST,null,null);
    }
}
