package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.Pripada;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PripadaManager extends GenericManager<Pripada, Long> {
    
}