package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Faktura;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class FakturaDaoTest extends BaseDaoTestCase {
    private FakturaDao fakturaDao;

    public void setFakturaDao(FakturaDao fakturaDao) {
        this.fakturaDao = fakturaDao;
    }

    public void testAddAndRemoveFaktura() throws Exception {
        Faktura faktura = new Faktura();

        // enter all required fields
        faktura.setDatum(new java.util.Date());

        log.debug("adding faktura...");
        faktura = fakturaDao.save(faktura);

        faktura = fakturaDao.get(faktura.getIdf());

        assertNotNull(faktura.getIdf());

        log.debug("removing faktura...");

        fakturaDao.remove(faktura.getIdf());

        try {
            fakturaDao.get(faktura.getIdf());
            fail("Faktura found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}