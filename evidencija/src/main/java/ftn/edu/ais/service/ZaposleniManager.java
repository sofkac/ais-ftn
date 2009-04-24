package ftn.edu.ais.service;

import ftn.edu.ais.service.GenericManager;
import ftn.edu.ais.model.Zaposleni;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ZaposleniManager extends GenericManager<Zaposleni, Long> {
    
}