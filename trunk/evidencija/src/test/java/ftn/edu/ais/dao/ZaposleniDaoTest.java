package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Zaposleni;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class ZaposleniDaoTest extends BaseDaoTestCase {
    private ZaposleniDao zaposleniDao;

    public void setZaposleniDao(ZaposleniDao zaposleniDao) {
        this.zaposleniDao = zaposleniDao;
    }

    public void testAddAndRemoveZaposleni() throws Exception {
        Zaposleni zaposleni = new Zaposleni();

        // enter all required fields
        zaposleni.setAdrz("NoUxJgCrWwSiOfZnTnKzXcFtQkKyFyYcHzJpShKcAiVxXwNhKt");
        zaposleni.setGradz("HtLxZqUsUnXjAhBxYcTs");
        zaposleni.setImez("HgTfEmNdIyLvOyDxHaWe");
        zaposleni.setJmbz("AtVhZiHmBnCtI");
        zaposleni.setMailz("JbHlMmXrSrWoZkHeMcZiHqKxRsZsXxMcXfZuVvNjAuMbIoVzIz");
        zaposleni.setPrzz("PjSfNmVrJnJaZxNbDaQl");
        zaposleni.setTelz("QjFfYuHdIlIrKzA");
        zaposleni.setZipz("GpKaTbThEg");

        log.debug("adding zaposleni...");
        zaposleni = zaposleniDao.save(zaposleni);

        zaposleni = zaposleniDao.get(zaposleni.getIdz());

        assertNotNull(zaposleni.getIdz());

        log.debug("removing zaposleni...");

        zaposleniDao.remove(zaposleni.getIdz());

        try {
            zaposleniDao.get(zaposleni.getIdz());
            fail("Zaposleni found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}