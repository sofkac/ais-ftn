package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Klijent;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface KlijentManager extends GenericManager<Klijent, Long> {
    
}