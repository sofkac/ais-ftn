package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.PolaznikDao;
import edu.ftn.ais.model.Polaznik;
import edu.ftn.ais.service.PolaznikManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "PolaznikService", endpointInterface = "edu.ftn.ais.service.PolaznikManager")
public class PolaznikManagerImpl extends GenericManagerImpl<Polaznik, Long> implements PolaznikManager {
    PolaznikDao polaznikDao;

    public PolaznikManagerImpl(PolaznikDao polaznikDao) {
        super(polaznikDao);
        this.polaznikDao = polaznikDao;
    }
}