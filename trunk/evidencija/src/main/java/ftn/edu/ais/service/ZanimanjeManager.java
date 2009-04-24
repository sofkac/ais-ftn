package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.Zanimanje;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ZanimanjeManager extends GenericManager<Zanimanje, Long> {
    
}