package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Osoblje;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class OsobljeDaoTest extends BaseDaoTestCase {
    private OsobljeDao osobljeDao;

    public void setOsobljeDao(OsobljeDao osobljeDao) {
        this.osobljeDao = osobljeDao;
    }

    public void testAddAndRemoveOsoblje() throws Exception {
        Osoblje osoblje = new Osoblje();

        // enter all required fields
        osoblje.setIme("IjSxThQiFqEoVaKuUmBh");
        osoblje.setPrezime("UlCgOqAqIbIqZpKwVwMcSeHjH");
        osoblje.setVrsta(30517292023388029L);

        log.debug("adding osoblje...");
        osoblje = osobljeDao.save(osoblje);

        osoblje = osobljeDao.get(osoblje.getOsobljeID());

        assertNotNull(osoblje.getOsobljeID());

        log.debug("removing osoblje...");

        osobljeDao.remove(osoblje.getOsobljeID());

        try {
            osobljeDao.get(osoblje.getOsobljeID());
            fail("Osoblje found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}