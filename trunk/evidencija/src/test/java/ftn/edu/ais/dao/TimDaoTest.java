package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Tim;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class TimDaoTest extends BaseDaoTestCase {
    private TimDao timDao;

    public void setTimDao(TimDao timDao) {
        this.timDao = timDao;
    }

    public void testAddAndRemoveTim() throws Exception {
        Tim tim = new Tim();

        // enter all required fields
        tim.setNazt("LjKjJyJdZhEbZlMvZsWzJgQkWwCmWa");

        log.debug("adding tim...");
        tim = timDao.save(tim);

        tim = timDao.get(tim.getIdt());

        assertNotNull(tim.getIdt());

        log.debug("removing tim...");

        timDao.remove(tim.getIdt());

        try {
            timDao.get(tim.getIdt());
            fail("Tim found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}