package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Roba;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class RobaDaoTest extends BaseDaoTestCase {
    private RobaDao robaDao;

    public void setRobaDao(RobaDao robaDao) {
        this.robaDao = robaDao;
    }

    public void testAddAndRemoveRoba() throws Exception {
        Roba roba = new Roba();

        // enter all required fields
        roba.setJm("VgAgWsJnRp");
        roba.setKolicina(4.2260983512125903E8L);
        roba.setNaziv("VdHxJxOrCxAfGgXqLcVjSuNsQlWfClYvGmOhVlMbWbKtCjCePl");

        log.debug("adding roba...");
        roba = robaDao.save(roba);

        roba = robaDao.get(roba.getIdr());

        assertNotNull(roba.getIdr());

        log.debug("removing roba...");

        robaDao.remove(roba.getIdr());

        try {
            robaDao.get(roba.getIdr());
            fail("Roba found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}