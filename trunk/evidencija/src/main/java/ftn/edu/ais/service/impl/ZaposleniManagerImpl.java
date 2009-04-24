package ftn.edu.ais.service.impl;

import ftn.edu.ais.dao.ZaposleniDao;
import ftn.edu.ais.model.Zaposleni;
import ftn.edu.ais.service.ZaposleniManager;
import ftn.edu.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "ZaposleniService", endpointInterface = "ftn.edu.ais.service.ZaposleniManager")
public class ZaposleniManagerImpl extends GenericManagerImpl<Zaposleni, Long> implements ZaposleniManager {
    ZaposleniDao zaposleniDao;

    public ZaposleniManagerImpl(ZaposleniDao zaposleniDao) {
        super(zaposleniDao);
        this.zaposleniDao = zaposleniDao;
    }
}