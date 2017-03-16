package com.sapient.assessment.dao;

import com.sapient.assessment.dao.mapper.CategoryMapper;
import com.sapient.assessment.dao.mapper.ClientMapper;
import com.sapient.assessment.data.client.Client;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * Created by djai10 on 9/30/2016.
 */
public interface ClientDao {

    @SqlQuery("select id, name,username,password from client")
    @Mapper(ClientMapper.class)
    List<Client> getAll();
    
    
    @SqlQuery("select c.id,c.name, c.username, c.password, c.email from client_details as c WHERE c.username= :Username AND c.password= :Password")
	@Mapper(ClientMapper.class)
	Client getClientDetails(@Bind("Username")String username,@Bind("Password")String password);

}
