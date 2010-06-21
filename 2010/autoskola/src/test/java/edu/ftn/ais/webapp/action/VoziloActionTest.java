package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.VoziloManager;
import edu.ftn.ais.model.Vozilo;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class VoziloActionTest extends BaseActionTestCase {
    private VoziloAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new VoziloAction();
        VoziloManager voziloManager = (VoziloManager) applicationContext.getBean("voziloManager");
        action.setVoziloManager(voziloManager);
    
        // add a test vozilo to the database
        Vozilo vozilo = new Vozilo();

        // enter all required fields
        vozilo.setMarka("NdEiGrSxSlIyUdSuHyDtCeWxVyZfWxNuDzAjYcTnXwMaM");
        vozilo.setModel("EnTmAkOaNaFpKkGkOqApCxDqIpVpSiDrDrXqCmDcFkMzA");
        vozilo.setRegBroj("BySaCsAlHk");

        voziloManager.save(vozilo);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getVoziloes().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setVoziloID(-1L);
        assertNull(action.getVozilo());
        assertEquals("success", action.edit());
        assertNotNull(action.getVozilo());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setVoziloID(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getVozilo());

        Vozilo vozilo = action.getVozilo();
        // update required fields
        vozilo.setMarka("GqYyXdEfAwPgVqIaHeIpVfWyKbVlWaHrZwNpImWuEiWgK");
        vozilo.setModel("JgQbPkTdXfKgJqQqRuWhAjVaJnYsMhAbVqOqAxYwNlMhY");
        vozilo.setRegBroj("NkKiXaZaPa");

        action.setVozilo(vozilo);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Vozilo vozilo = new Vozilo();
        vozilo.setVoziloID(-2L);
        action.setVozilo(vozilo);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}