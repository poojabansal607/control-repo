package com.sapient.assessment.dao.mapper;

import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.client.ClientKey;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

/**
 * Created by djai10 on 10/4/2016.
 */
public class ClientMapper implements ResultSetMapper<Client> {
    public Client map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Client(new ClientKey(r.getLong("id")), r.getString("name"),r.getString("username"),r.getString("password"),r.getString("email"),Collections.EMPTY_LIST);
    }
}
