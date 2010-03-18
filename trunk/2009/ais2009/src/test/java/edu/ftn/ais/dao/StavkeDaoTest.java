package edu.ftn.ais.dao;

import java.math.BigDecimal;

import org.springframework.dao.DataAccessException;

import edu.ftn.ais.model.Stavke;

public class StavkeDaoTest extends BaseDaoTestCase {
    private StavkeDao stavkeDao;
    private FakturaDao fakturaDao;
    private RobaDao robaDao;

    public void setStavkeDao(StavkeDao stavkeDao) {
        this.stavkeDao = stavkeDao;
    }

    public void setFakturaDao(FakturaDao fakturaDao) {
        this.fakturaDao = fakturaDao;
    }

    public void setRobaDao(RobaDao robaDao) {
        this.robaDao = robaDao;
    }

    public void testAddAndRemoveStavke() throws Exception {
        Stavke stavke = new Stavke();

        //added by neso
        stavke.setFaktura(fakturaDao.get(-1L));
        stavke.setRoba(robaDao.get(-1L));
        //end
        
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