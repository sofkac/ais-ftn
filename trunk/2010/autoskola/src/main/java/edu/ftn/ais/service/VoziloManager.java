package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Vozilo;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface VoziloManager extends GenericManager<Vozilo, Long> {
    
}