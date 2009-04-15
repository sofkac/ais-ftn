package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Klijent;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class KlijentDaoTest extends BaseDaoTestCase {
    private KlijentDao klijentDao;

    public void setKlijentDao(KlijentDao klijentDao) {
        this.klijentDao = klijentDao;
    }

    public void testAddAndRemoveKlijent() throws Exception {
        Klijent klijent = new Klijent();

        // enter all required fields
        klijent.setAdresa("DvCtIvGzRsYfWnTzLlIvBrRdCpCkLwIkOcWhNhAaCgKkY");
        klijent.setMesto("SlIeRdXvJtDcXlQeMyMmFjNvQ");
        klijent.setNaziv("EnYiJwDqFbSdCgAnMkNhZoZmHuLiSbEsWfRlGpEjHjXpN");

        log.debug("adding klijent...");
        klijent = klijentDao.save(klijent);

        klijent = klijentDao.get(klijent.getIdk());

        assertNotNull(klijent.getIdk());

        log.debug("removing klijent...");

        klijentDao.remove(klijent.getIdk());

        try {
            klijentDao.get(klijent.getIdk());
            fail("Klijent found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}