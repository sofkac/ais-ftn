package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.RobaDao;
import edu.ftn.ais.model.Roba;
import edu.ftn.ais.service.RobaManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "RobaService", endpointInterface = "edu.ftn.ais.service.RobaManager")
public class RobaManagerImpl extends GenericManagerImpl<Roba, Long> implements RobaManager {
    RobaDao robaDao;

    public RobaManagerImpl(RobaDao robaDao) {
        super(robaDao);
        this.robaDao = robaDao;
    }
}