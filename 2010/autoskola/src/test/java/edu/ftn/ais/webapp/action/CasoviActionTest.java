package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.CasoviManager;
import edu.ftn.ais.service.OsobljeManager;
import edu.ftn.ais.service.PolaznikManager;
import edu.ftn.ais.service.VoziloManager;
import edu.ftn.ais.model.Casovi;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class CasoviActionTest extends BaseActionTestCase {
    private CasoviAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new CasoviAction();
        CasoviManager casoviManager = (CasoviManager) applicationContext.getBean("casoviManager");
        action.setCasoviManager(casoviManager);

        //added by neso
        OsobljeManager osobljeManager = (OsobljeManager) applicationContext.getBean("osobljeManager");
        VoziloManager voziloManager = (VoziloManager) applicationContext.getBean("voziloManager");
        PolaznikManager polaznikManager = (PolaznikManager) applicationContext.getBean("polaznikManager");
       
        // add a test casovi to the database
        Casovi casovi = new Casovi();

        // enter all required fields
        casovi.setDatumCasa(new java.util.Date());
        casovi.setStatus(69963949825942927L);
        casovi.setVremeDo("09:00:00");
        casovi.setVremeOd("09:00:00");
        casovi.setVrsta(35641863902682066L);
        //added by neso
        casovi.setOsobljeFK(osobljeManager.get(-1L));
        casovi.setVoziloFK(voziloManager.get(-1L));
        casovi.setPolaznikFK(polaznikManager.get(-1L));

        casoviManager.save(casovi);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getCasovies().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdCas(-1L);
        assertNull(action.getCasovi());
        assertEquals("success", action.edit());
        assertNotNull(action.getCasovi());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdCas(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getCasovi());

        Casovi casovi = action.getCasovi();
        // update required fields
        casovi.setDatumCasa(new java.util.Date());
        casovi.setStatus(365783L);
        casovi.setVremeDo("09:00:00");
        casovi.setVremeOd("09:00:00");
        casovi.setVrsta(204694574775364L);

        action.setCasovi(casovi);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Casovi casovi = new Casovi();
        casovi.setIdCas(-2L);
        action.setCasovi(casovi);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}