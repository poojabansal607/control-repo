package com.sapient.assessment.service;

import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.client.ClientKey;

import java.util.List;

/**
 * Created by djai10 on 9/30/2016.
 */
public interface ClientService {

    List<Client> getClients(String name);
    List<Client> getClients(ClientKey id);
}
