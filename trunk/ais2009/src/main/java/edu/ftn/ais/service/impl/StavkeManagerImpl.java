package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.StavkeDao;
import edu.ftn.ais.model.Stavke;
import edu.ftn.ais.service.StavkeManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "StavkeService", endpointInterface = "edu.ftn.ais.service.StavkeManager")
public class StavkeManagerImpl extends GenericManagerImpl<Stavke, Long> implements StavkeManager {
    StavkeDao stavkeDao;

    public StavkeManagerImpl(StavkeDao stavkeDao) {
        super(stavkeDao);
        this.stavkeDao = stavkeDao;
    }
}