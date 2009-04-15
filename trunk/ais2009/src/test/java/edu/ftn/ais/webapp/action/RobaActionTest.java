package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.RobaManager;
import edu.ftn.ais.model.Roba;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class RobaActionTest extends BaseActionTestCase {
    private RobaAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new RobaAction();
        RobaManager robaManager = (RobaManager) applicationContext.getBean("robaManager");
        action.setRobaManager(robaManager);
    
        // add a test roba to the database
        Roba roba = new Roba();

        // enter all required fields
        roba.setJm("LeNlCaPkUa");
        roba.setKolicina(2.5187448674213138E8L);
        roba.setNaziv("EgQsKbDyLaYwPaPbEcEqDhBfQpAwZcGxTnZlHaFuIfSoRiAkXk");

        robaManager.save(roba);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getRobas().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdr(-1L);
        assertNull(action.getRoba());
        assertEquals("success", action.edit());
        assertNotNull(action.getRoba());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdr(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getRoba());

        Roba roba = action.getRoba();
        // update required fields
        roba.setJm("EcZfFxXqBa");
        roba.setKolicina(7.661785500696265E8L);
        roba.setNaziv("MgXoFuAfSuYlFuGaHxZiEhXeOqVxKuBjQaPdUzLiNrPrBjBoSe");

        action.setRoba(roba);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Roba roba = new Roba();
        roba.setIdr(-2L);
        action.setRoba(roba);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}