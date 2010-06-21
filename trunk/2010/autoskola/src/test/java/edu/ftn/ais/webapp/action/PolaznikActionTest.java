package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.PolaznikManager;
import edu.ftn.ais.model.Polaznik;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class PolaznikActionTest extends BaseActionTestCase {
    private PolaznikAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new PolaznikAction();
        PolaznikManager polaznikManager = (PolaznikManager) applicationContext.getBean("polaznikManager");
        action.setPolaznikManager(polaznikManager);
    
        // add a test polaznik to the database
        Polaznik polaznik = new Polaznik();

        // enter all required fields
        polaznik.setIme("KhBsGcTdBeXuUbVeCrWl");
        polaznik.setPrezime("VvEuUxRbCzYfFmJdIaOcOdCuI");

        polaznikManager.save(polaznik);
    }

    public void testSearch() throws Exception {
    	System.out.println("tui saaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaam");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getPolazniks().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdpolaznik(-1L);
        assertNull(action.getPolaznik());
        assertEquals("success", action.edit());
        assertNotNull(action.getPolaznik());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdpolaznik(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getPolaznik());

        Polaznik polaznik = action.getPolaznik();
        // update required fields
        polaznik.setIme("BgTpYkKnFnAvJqCaCsYu");
        polaznik.setPrezime("OcXeAtTzMiNjYpOcSiFzKlRbC");

        action.setPolaznik(polaznik);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Polaznik polaznik = new Polaznik();
        polaznik.setIdpolaznik(-2L);
        action.setPolaznik(polaznik);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}