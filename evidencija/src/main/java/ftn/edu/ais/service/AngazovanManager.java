package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.Angazovan;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface AngazovanManager extends GenericManager<Angazovan, Long> {
    
}