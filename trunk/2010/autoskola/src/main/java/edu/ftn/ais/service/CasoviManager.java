package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Casovi;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface CasoviManager extends GenericManager<Casovi, Long> {
    
}