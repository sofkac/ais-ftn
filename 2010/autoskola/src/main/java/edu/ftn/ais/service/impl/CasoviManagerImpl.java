package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.CasoviDao;
import edu.ftn.ais.model.Casovi;
import edu.ftn.ais.service.CasoviManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "CasoviService", endpointInterface = "edu.ftn.ais.service.CasoviManager")
public class CasoviManagerImpl extends GenericManagerImpl<Casovi, Long> implements CasoviManager {
    CasoviDao casoviDao;

    public CasoviManagerImpl(CasoviDao casoviDao) {
        super(casoviDao);
        this.casoviDao = casoviDao;
    }
}