package edu.ftn.ais.dao;

import org.springframework.dao.DataAccessException;

import edu.ftn.ais.model.Roba;

public class RobaDaoTest extends BaseDaoTestCase {
    private RobaDao robaDao;

    public void setRobaDao(RobaDao robaDao) {
        this.robaDao = robaDao;
    }

    public void testAddAndRemoveRoba() throws Exception {
        Roba roba = new Roba();

        // enter all required fields
        roba.setJm("VgAgWsJnRp");
        roba.setKolicina(422609835121259038L);
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