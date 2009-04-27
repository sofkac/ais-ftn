package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Zaposleni;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class ZaposleniDaoTest extends BaseDaoTestCase {
    private ZaposleniDao zaposleniDao;
    private ZanimanjeDao zanimanjeDao;//added by Sofija

    public void setZaposleniDao(ZaposleniDao zaposleniDao) {
        this.zaposleniDao = zaposleniDao;
    }
    
    //added by Sofija
     public void setZanimanjeDao(ZanimanjeDao zanimanjeDao) {
        this.zanimanjeDao = zanimanjeDao;
    }
    //end
    
    public void testAddAndRemoveZaposleni() throws Exception {
        Zaposleni zaposleni = new Zaposleni();
        
        //added by Sofija
        zaposleni.setZanimanje(zanimanjeDao.get(-1L));
        //end

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