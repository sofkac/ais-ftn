package ftn.edu.ais.service.impl;

import ftn.edu.ais.dao.ZanimanjeDao;
import ftn.edu.ais.model.Zanimanje;
import ftn.edu.ais.service.ZanimanjeManager;
import ftn.edu.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "ZanimanjeService", endpointInterface = "ftn.edu.ais.service.ZanimanjeManager")
public class ZanimanjeManagerImpl extends GenericManagerImpl<Zanimanje, Long> implements ZanimanjeManager {
    ZanimanjeDao zanimanjeDao;

    public ZanimanjeManagerImpl(ZanimanjeDao zanimanjeDao) {
        super(zanimanjeDao);
        this.zanimanjeDao = zanimanjeDao;
    }
}