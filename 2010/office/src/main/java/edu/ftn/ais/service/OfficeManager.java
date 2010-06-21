package edu.ftn.ais.service;

import edu.ftn.ais.service.GenericManager;
import edu.ftn.ais.model.Office;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface OfficeManager extends GenericManager<Office, Long> {
    
}