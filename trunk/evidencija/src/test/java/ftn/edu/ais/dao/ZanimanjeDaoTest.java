package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Zanimanje;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class ZanimanjeDaoTest extends BaseDaoTestCase {
    private ZanimanjeDao zanimanjeDao;

    public void setZanimanjeDao(ZanimanjeDao zanimanjeDao) {
        this.zanimanjeDao = zanimanjeDao;
    }

    public void testAddAndRemoveZanimanje() throws Exception {
        Zanimanje zanimanje = new Zanimanje();

        // enter all required fields
        zanimanje.setNazzan("MlMmDgHoCpCrLxHpUpBxRcGxGmQbMp");

        log.debug("adding zanimanje...");
        zanimanje = zanimanjeDao.save(zanimanje);

        zanimanje = zanimanjeDao.get(zanimanje.getIdzan());

        assertNotNull(zanimanje.getIdzan());

        log.debug("removing zanimanje...");

        zanimanjeDao.remove(zanimanje.getIdzan());

        try {
            zanimanjeDao.get(zanimanje.getIdzan());
            fail("Zanimanje found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}