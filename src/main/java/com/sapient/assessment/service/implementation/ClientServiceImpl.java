package com.sapient.assessment.service.implementation;

import com.sapient.assessment.dao.ClientDao;
import com.sapient.assessment.data.client.Client;
import com.sapient.assessment.data.client.ClientKey;
import com.sapient.assessment.service.ClientService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by djai10 on 9/30/2016.
 */
public class ClientServiceImpl implements ClientService {
    private final ClientDao dao;

    public ClientServiceImpl(ClientDao dao) {

        this.dao = dao;
    }

    public List<Client> getClients(String name) {
        List<Client> all = dao.getAll();
        for (Client client : all) {

        }
        return all;
    }

    public List<Client> getClients(ClientKey id) {
        return dao.getAll();
    }
}
