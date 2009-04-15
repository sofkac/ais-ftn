package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.FakturaManager;
import edu.ftn.ais.model.Faktura;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class FakturaActionTest extends BaseActionTestCase {
    private FakturaAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new FakturaAction();
        FakturaManager fakturaManager = (FakturaManager) applicationContext.getBean("fakturaManager");
        action.setFakturaManager(fakturaManager);
    
        // add a test faktura to the database
        Faktura faktura = new Faktura();

        // enter all required fields
        faktura.setDatum(new java.util.Date());

        fakturaManager.save(faktura);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getFakturas().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdf(-1L);
        assertNull(action.getFaktura());
        assertEquals("success", action.edit());
        assertNotNull(action.getFaktura());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdf(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getFaktura());

        Faktura faktura = action.getFaktura();
        // update required fields
        faktura.setDatum(new java.util.Date());

        action.setFaktura(faktura);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Faktura faktura = new Faktura();
        faktura.setIdf(-2L);
        action.setFaktura(faktura);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}