package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Client;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ClientManager extends GenericManager<Client, Long> {
    
}