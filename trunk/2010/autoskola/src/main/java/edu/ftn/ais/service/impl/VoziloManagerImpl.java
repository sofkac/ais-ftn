package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.VoziloDao;
import edu.ftn.ais.model.Vozilo;
import edu.ftn.ais.service.VoziloManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "VoziloService", endpointInterface = "edu.ftn.ais.service.VoziloManager")
public class VoziloManagerImpl extends GenericManagerImpl<Vozilo, Long> implements VoziloManager {
    VoziloDao voziloDao;

    public VoziloManagerImpl(VoziloDao voziloDao) {
        super(voziloDao);
        this.voziloDao = voziloDao;
    }
}