package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Roba;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface RobaManager extends GenericManager<Roba, Long> {
    
}