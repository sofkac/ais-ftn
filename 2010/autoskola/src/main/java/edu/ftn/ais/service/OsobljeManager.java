package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Osoblje;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface OsobljeManager extends GenericManager<Osoblje, Long> {
    
}