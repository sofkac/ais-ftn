package ftn.edu.ais.dao;

import ftn.edu.ais.dao.BaseDaoTestCase;
import ftn.edu.ais.model.Pripada;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class PripadaDaoTest extends BaseDaoTestCase {
    private PripadaDao pripadaDao;
    private ZanimanjeDao zanimanjeDao;//dodato
    private TimDao timDao;//dodato

    public void setPripadaDao(PripadaDao pripadaDao) {
        this.pripadaDao = pripadaDao;
    }
//dodato
    public void setTimDao(TimDao timDao) {
        this.timDao = timDao;
    }

    public void setZanimanjeDao(ZanimanjeDao zanimanjeDao) {
        this.zanimanjeDao = zanimanjeDao;
    }
//kraj dodato
    
    public void testAddAndRemovePripada() throws Exception {
        Pripada pripada = new Pripada();
        
        //added by Sofija :)
        pripada.setTim(timDao.get(-1L));
        pripada.setZanimanje(zanimanjeDao.get(-1L));
        //end

        // enter all required fields
        pripada.setBrlj(new Long("2"));

        log.debug("adding pripada...");
        pripada = pripadaDao.save(pripada);

        pripada = pripadaDao.get(pripada.getIdp());

        assertNotNull(pripada.getIdp());

        log.debug("removing pripada...");

        pripadaDao.remove(pripada.getIdp());

        try {
            pripadaDao.get(pripada.getIdp());
            fail("Pripada found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}