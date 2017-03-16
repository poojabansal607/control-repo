package com.sapient.assessment.service;

import java.util.List;

import com.sapient.assessment.data.client.Client;


public interface LoginService {
	Client checkLoginDetails(String username, String password);
}
