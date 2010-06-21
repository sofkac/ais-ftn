package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.ClientDao;
import edu.ftn.ais.model.Client;
import edu.ftn.ais.service.ClientManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "ClientService", endpointInterface = "edu.ftn.ais.service.ClientManager")
public class ClientManagerImpl extends GenericManagerImpl<Client, Long> implements ClientManager {
    ClientDao clientDao;

    public ClientManagerImpl(ClientDao clientDao) {
        super(clientDao);
        this.clientDao = clientDao;
    }
}