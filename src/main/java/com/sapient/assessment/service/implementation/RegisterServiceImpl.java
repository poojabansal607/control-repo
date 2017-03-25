package com.sapient.assessment.service.implementation;

import java.util.List;

import com.sapient.assessment.dao.LoginDAO;
import com.sapient.assessment.dao.RegisterDAO;
import com.sapient.assessment.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{
	private final RegisterDAO registerDAO;

	public RegisterServiceImpl (RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	public long checkUserName(String username) {
		long existuserName=registerDAO.getusernames(username);
		return existuserName;
	}

	public long checkClientName(String clientname) {
		long existClientName=registerDAO.getclientname(clientname);
		return existClientName;
	}

	public void saveClientDetails(String clientName, String userName, String password, String email) {
		System.out.println("Inside Service impl " + userName+" "+clientName);


		 registerDAO.saveClient(clientName, userName, password,email);

	}

	public long checkEmailId(String emailId) {
		long existEmailid=registerDAO.getemail(emailId);
		return existEmailid;
	}
}
