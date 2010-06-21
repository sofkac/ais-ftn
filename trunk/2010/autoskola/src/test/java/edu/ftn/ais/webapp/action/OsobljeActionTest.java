package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.OsobljeManager;
import edu.ftn.ais.model.Osoblje;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class OsobljeActionTest extends BaseActionTestCase {
    private OsobljeAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new OsobljeAction();
        OsobljeManager osobljeManager = (OsobljeManager) applicationContext.getBean("osobljeManager");
        action.setOsobljeManager(osobljeManager);
    
        // add a test osoblje to the database
        Osoblje osoblje = new Osoblje();

        // enter all required fields
        osoblje.setIme("MnRwLiZxAmXyEoUzJxAz");
        osoblje.setPrezime("WaBnUtNpUrVvZrTeNlDuGvQqJ");
        osoblje.setVrsta(766875245388L);

        osobljeManager.save(osoblje);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getOsobljes().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setOsobljeID(-1L);
        assertNull(action.getOsoblje());
        assertEquals("success", action.edit());
        assertNotNull(action.getOsoblje());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setOsobljeID(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getOsoblje());

        Osoblje osoblje = action.getOsoblje();
        // update required fields
        osoblje.setIme("FdXkZwRdAzImKlSrUyRd");
        osoblje.setPrezime("DkNwIjVfAhEqXvVzEoBkBtHrL");
        osoblje.setVrsta(15507774508060269L);

        action.setOsoblje(osoblje);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Osoblje osoblje = new Osoblje();
        osoblje.setOsobljeID(-2L);
        action.setOsoblje(osoblje);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}