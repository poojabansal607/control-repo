package com.sapient.assessment.service;

import java.util.List;

public interface RegisterService {
long checkUserName(String username);
long checkClientName(String name);
void saveClientDetails(String clientName,String userName,String password,String email);
}
