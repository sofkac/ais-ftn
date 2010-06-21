package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.OsobljeDao;
import edu.ftn.ais.model.Osoblje;
import edu.ftn.ais.service.OsobljeManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "OsobljeService", endpointInterface = "edu.ftn.ais.service.OsobljeManager")
public class OsobljeManagerImpl extends GenericManagerImpl<Osoblje, Long> implements OsobljeManager {
    OsobljeDao osobljeDao;

    public OsobljeManagerImpl(OsobljeDao osobljeDao) {
        super(osobljeDao);
        this.osobljeDao = osobljeDao;
    }
}