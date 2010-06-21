package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Casovi;
import edu.ftn.ais.model.Osoblje;

import org.springframework.dao.DataAccessException;

import java.util.List;

public class CasoviDaoTest extends BaseDaoTestCase {
    private CasoviDao casoviDao;
    //added by neso
    private VoziloDao voziloDao;
    private OsobljeDao osobljeDao;
    private PolaznikDao polaznikDao;

    public void setCasoviDao(CasoviDao casoviDao) {
        this.casoviDao = casoviDao;
    }

    //added by neso
    public void setVoziloDao(VoziloDao voziloDao){
    	this.voziloDao=voziloDao;
    }
    
    public void setOsobljeDao(OsobljeDao osobljeDao){
    	this.osobljeDao = osobljeDao;
    }
    public void setPolaznikDao(PolaznikDao polaznikDao){
    	this.polaznikDao = polaznikDao;
    }
    
    public void testAddAndRemoveCasovi() throws Exception {
        Casovi casovi = new Casovi();

        //added
        casovi.setVoziloFK(voziloDao.get(-1L));
        casovi.setOsobljeFK(osobljeDao.get(-1L));
        casovi.setPolaznikFK(polaznikDao.get(-1L));
        
        // enter all required fields
        casovi.setDatumCasa(new java.util.Date());
        casovi.setStatus(125797007905637129L);
        casovi.setVremeDo("15:15:00");
        casovi.setVremeOd("17:00:00");
        casovi.setVrsta(1023441206766539L);

        log.debug("adding casovi...");
        casovi = casoviDao.save(casovi);

        casovi = casoviDao.get(casovi.getIdCas());

        assertNotNull(casovi.getIdCas());

        log.debug("removing casovi...");

        casoviDao.remove(casovi.getIdCas());

        try {
            casoviDao.get(casovi.getIdCas());
            fail("Casovi found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}