package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Stavke;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface StavkeManager extends GenericManager<Stavke, Long> {
    
}