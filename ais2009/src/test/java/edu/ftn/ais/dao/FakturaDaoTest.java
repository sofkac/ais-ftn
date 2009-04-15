package edu.ftn.ais.dao;

import org.springframework.dao.DataAccessException;

import edu.ftn.ais.model.Faktura;

public class FakturaDaoTest extends BaseDaoTestCase {
    private FakturaDao fakturaDao;
    private KlijentDao klijentDao;

    public void setFakturaDao(FakturaDao fakturaDao) {
        this.fakturaDao = fakturaDao;
    }

    public void setKlijentDao(KlijentDao klijentDao) {
        this.klijentDao = klijentDao;
    }

    public void testAddAndRemoveFaktura() throws Exception {
        Faktura faktura = new Faktura();

        //added by neso
        faktura.setKlijent(klijentDao.get(-1L));
        //end
        
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