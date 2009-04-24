package ftn.edu.ais.service.impl;

import ftn.edu.ais.dao.PripadaDao;
import ftn.edu.ais.model.Pripada;
import ftn.edu.ais.service.PripadaManager;
import ftn.edu.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "PripadaService", endpointInterface = "ftn.edu.ais.service.PripadaManager")
public class PripadaManagerImpl extends GenericManagerImpl<Pripada, Long> implements PripadaManager {
    PripadaDao pripadaDao;

    public PripadaManagerImpl(PripadaDao pripadaDao) {
        super(pripadaDao);
        this.pripadaDao = pripadaDao;
    }
}