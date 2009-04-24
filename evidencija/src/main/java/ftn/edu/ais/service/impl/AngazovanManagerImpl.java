package ftn.edu.ais.service.impl;

import ftn.edu.ais.dao.AngazovanDao;
import ftn.edu.ais.model.Angazovan;
import ftn.edu.ais.service.AngazovanManager;
import ftn.edu.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "AngazovanService", endpointInterface = "ftn.edu.ais.service.AngazovanManager")
public class AngazovanManagerImpl extends GenericManagerImpl<Angazovan, Long> implements AngazovanManager {
    AngazovanDao angazovanDao;

    public AngazovanManagerImpl(AngazovanDao angazovanDao) {
        super(angazovanDao);
        this.angazovanDao = angazovanDao;
    }
}