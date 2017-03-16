package com.sapient.assessment.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;



public interface RegisterDAO {
	@SqlQuery("select count(username) from client_details as c where c.username= :username")
	long getusernames(@Bind("username") String username);
	
	@SqlQuery("select count(name) from client_details as c where c.name= :clientname")
	long getclientname(@Bind("clientname") String clientname);
	
	
	
	
	  @SqlUpdate("insert into client_details (name,username,password,email) values (:clientName,:userNames,:password,:email)")
	  void saveClient(@Bind("clientName") String clientName, @Bind("userNames") String userName, @Bind("password") String password, @Bind("email") String email);
}
