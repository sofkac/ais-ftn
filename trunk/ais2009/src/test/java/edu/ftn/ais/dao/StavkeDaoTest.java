package edu.ftn.ais.dao;

import java.math.BigDecimal;

import org.springframework.dao.DataAccessException;

import edu.ftn.ais.model.Stavke;

public class StavkeDaoTest extends BaseDaoTestCase {
    private StavkeDao stavkeDao;

    public void setStavkeDao(StavkeDao stavkeDao) {
        this.stavkeDao = stavkeDao;
    }

    public void testAddAndRemoveStavke() throws Exception {
        Stavke stavke = new Stavke();

        // enter all required fields
        stavke.setKolicina(new BigDecimal("11.11"));

        log.debug("adding stavke...");
        stavke = stavkeDao.save(stavke);

        stavke = stavkeDao.get(stavke.getIds());

        assertNotNull(stavke.getIds());

        log.debug("removing stavke...");

        stavkeDao.remove(stavke.getIds());

        try {
            stavkeDao.get(stavke.getIds());
            fail("Stavke found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}