package edu.ftn.ais.dao;

import java.math.BigDecimal;

import org.springframework.dao.DataAccessException;

import edu.ftn.ais.model.Placanja;

public class PlacanjaDaoTest extends BaseDaoTestCase {
    private PlacanjaDao placanjaDao;
    //added by neso
    private PolaznikDao polaznikDao;

    public void setPlacanjaDao(PlacanjaDao placanjaDao) {
        this.placanjaDao = placanjaDao;
    }
    
    //added by neso
    public void setPolaznikDao(PolaznikDao polaznikDao){
    	this.polaznikDao=polaznikDao;
    }

    public void testAddAndRemovePlacanja() throws Exception {
        Placanja placanja = new Placanja();

        //added
        placanja.setPolaznikFK(polaznikDao.get(-1L));
        
        // enter all required fields
        placanja.setDate(new java.util.Date());
        placanja.setIznos(new BigDecimal("32452.234"));

        log.debug("adding placanja...");
        placanja = placanjaDao.save(placanja);

        placanja = placanjaDao.get(placanja.getIdplacanje());

        assertNotNull(placanja.getIdplacanje());

        log.debug("removing placanja...");

        placanjaDao.remove(placanja.getIdplacanje());

        try {
            placanjaDao.get(placanja.getIdplacanje());
            fail("Placanja found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}