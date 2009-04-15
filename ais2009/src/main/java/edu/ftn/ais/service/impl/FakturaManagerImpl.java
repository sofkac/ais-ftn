package edu.ftn.ais.service.impl;

import javax.jws.WebService;

import edu.ftn.ais.dao.FakturaDao;
import edu.ftn.ais.model.Faktura;
import edu.ftn.ais.service.FakturaManager;

@WebService(serviceName = "FakturaService", endpointInterface = "edu.ftn.ais.service.FakturaManager")
public class FakturaManagerImpl extends GenericManagerImpl<Faktura, Long> implements FakturaManager {
    FakturaDao fakturaDao;

    public FakturaManagerImpl(FakturaDao fakturaDao) {
        super(fakturaDao);
        this.fakturaDao = fakturaDao;
    }
}