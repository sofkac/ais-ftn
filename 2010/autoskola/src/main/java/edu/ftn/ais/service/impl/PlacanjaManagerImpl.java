package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.PlacanjaDao;
import edu.ftn.ais.model.Placanja;
import edu.ftn.ais.service.PlacanjaManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "PlacanjaService", endpointInterface = "edu.ftn.ais.service.PlacanjaManager")
public class PlacanjaManagerImpl extends GenericManagerImpl<Placanja, Long> implements PlacanjaManager {
    PlacanjaDao placanjaDao;

    public PlacanjaManagerImpl(PlacanjaDao placanjaDao) {
        super(placanjaDao);
        this.placanjaDao = placanjaDao;
    }
}