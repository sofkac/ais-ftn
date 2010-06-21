package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Office;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class OfficeDaoTest extends BaseDaoTestCase {
    private OfficeDao officeDao;
    //neso
    private ClientDao clientDao;

    public void setOfficeDao(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    public void setClientDao(ClientDao clientDao){
    	this.clientDao=clientDao;
    }
    
    public void testAddAndRemoveOffice() throws Exception {
        Office office = new Office();

        // enter all required fields
        office.setAdresa("UlJcTtCrPvHaDiOzYlNzHrHxDiYqHsZmQkSbMfUsLoDoF");
        office.setGrad("SsIkZnUdTrXgZkIpZiUeGhUpTwMbJdIkXbUaNnXjPdNcJ");
        office.setClient(clientDao.get(-1L));
        
        log.debug("adding office...");
        office = officeDao.save(office);

        office = officeDao.get(office.getIdoffice());

        assertNotNull(office.getIdoffice());

        log.debug("removing office...");

        officeDao.remove(office.getIdoffice());

        try {
            officeDao.get(office.getIdoffice());
            fail("Office found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}