package edu.ftn.ais.dao;

import org.springframework.dao.DataAccessException;

import edu.ftn.ais.model.Polaznik;

public class PolaznikDaoTest extends BaseDaoTestCase {
    private PolaznikDao polaznikDao;

    public void setPolaznikDao(PolaznikDao polaznikDao) {
        this.polaznikDao = polaznikDao;
    }

    public void testAddAndRemovePolaznik() throws Exception {
        Polaznik polaznik = new Polaznik();

        // enter all required fields
        polaznik.setIme("YlKsPcNfMeXrTiDyRoZk");
        polaznik.setPrezime("PtXoYaJoUtGhFbJrSlSpXzUsH");
        polaznik.setAdresa("some address");

        log.debug("adding polaznik...");
        polaznik = polaznikDao.save(polaznik);

        polaznik = polaznikDao.get(polaznik.getIdpolaznik());

        assertNotNull(polaznik.getIdpolaznik());

        log.debug("removing polaznik...");

        polaznikDao.remove(polaznik.getIdpolaznik());

        try {
            polaznikDao.get(polaznik.getIdpolaznik());
            fail("Polaznik found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}