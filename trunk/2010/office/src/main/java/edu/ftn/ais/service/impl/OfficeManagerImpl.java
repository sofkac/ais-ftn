package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.OfficeDao;
import edu.ftn.ais.model.Office;
import edu.ftn.ais.service.OfficeManager;
import edu.ftn.ais.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "OfficeService", endpointInterface = "edu.ftn.ais.service.OfficeManager")
public class OfficeManagerImpl extends GenericManagerImpl<Office, Long> implements OfficeManager {
    OfficeDao officeDao;

    public OfficeManagerImpl(OfficeDao officeDao) {
        super(officeDao);
        this.officeDao = officeDao;
    }
}