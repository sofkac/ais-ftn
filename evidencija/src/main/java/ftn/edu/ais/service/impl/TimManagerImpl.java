package ftn.edu.ais.service.impl;

import ftn.edu.ais.dao.TimDao;
import ftn.edu.ais.model.Tim;
import ftn.edu.ais.service.TimManager;
import ftn.edu.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "TimService", endpointInterface = "ftn.edu.ais.service.TimManager")
public class TimManagerImpl extends GenericManagerImpl<Tim, Long> implements TimManager {
    TimDao timDao;

    public TimManagerImpl(TimDao timDao) {
        super(timDao);
        this.timDao = timDao;
    }
}