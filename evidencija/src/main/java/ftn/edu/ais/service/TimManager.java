package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.Tim;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface TimManager extends GenericManager<Tim, Long> {
    
}