package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Vozilo;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class VoziloDaoTest extends BaseDaoTestCase {
    private VoziloDao voziloDao;

    public void setVoziloDao(VoziloDao voziloDao) {
        this.voziloDao = voziloDao;
    }

    public void testAddAndRemoveVozilo() throws Exception {
        Vozilo vozilo = new Vozilo();

        // enter all required fields
        vozilo.setMarka("HaOdNiFkUaNmFjPpApPqCnOsXzJmTgFtYdByFfVgEpPhO");
        vozilo.setModel("LxDuXsSeDlYeMxHtMsInMzBjEjEfRoVqXoNdFbPkWuRbF");
        vozilo.setRegBroj("VaRfUaEhYh");

        log.debug("adding vozilo...");
        vozilo = voziloDao.save(vozilo);

        vozilo = voziloDao.get(vozilo.getVoziloID());

        assertNotNull(vozilo.getVoziloID());

        log.debug("removing vozilo...");

        voziloDao.remove(vozilo.getVoziloID());

        try {
            voziloDao.get(vozilo.getVoziloID());
            fail("Vozilo found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}