package edu.ftn.ais.webapp.action;

import java.math.BigDecimal;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.PlacanjaManager;
import edu.ftn.ais.service.PolaznikManager;
import edu.ftn.ais.model.Placanja;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class PlacanjaActionTest extends BaseActionTestCase {
    private PlacanjaAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new PlacanjaAction();
        PlacanjaManager placanjaManager = (PlacanjaManager) applicationContext.getBean("placanjaManager");
        action.setPlacanjaManager(placanjaManager);
    
        //added by neso
        PolaznikManager polaznikManager = (PolaznikManager) applicationContext.getBean("polaznikManager");
        
        // add a test placanja to the database
        Placanja placanja = new Placanja();

        // enter all required fields
        placanja.setDate(new java.util.Date());
        placanja.setIznos(new BigDecimal("222.333"));
        //added by neso
        placanja.setPolaznikFK(polaznikManager.get(-1L));

        placanjaManager.save(placanja);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getPlacanjas().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdplacanje(-1L);
        assertNull(action.getPlacanja());
        assertEquals("success", action.edit());
        assertNotNull(action.getPlacanja());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdplacanje(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getPlacanja());

        Placanja placanja = action.getPlacanja();
        // update required fields
        placanja.setDate(new java.util.Date());
        placanja.setIznos(new BigDecimal("55.66"));

        action.setPlacanja(placanja);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Placanja placanja = new Placanja();
        placanja.setIdplacanje(-2L);
        action.setPlacanja(placanja);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}