package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.KlijentDao;
import edu.ftn.ais.model.Klijent;
import edu.ftn.ais.service.KlijentManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "KlijentService", endpointInterface = "edu.ftn.ais.service.KlijentManager")
public class KlijentManagerImpl extends GenericManagerImpl<Klijent, Long> implements KlijentManager {
    KlijentDao klijentDao;

    public KlijentManagerImpl(KlijentDao klijentDao) {
        super(klijentDao);
        this.klijentDao = klijentDao;
    }
}