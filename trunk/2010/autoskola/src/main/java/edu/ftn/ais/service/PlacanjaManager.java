package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Placanja;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PlacanjaManager extends GenericManager<Placanja, Long> {
    
}