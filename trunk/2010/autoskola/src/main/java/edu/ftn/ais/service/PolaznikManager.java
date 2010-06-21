package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Polaznik;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PolaznikManager extends GenericManager<Polaznik, Long> {
    
}