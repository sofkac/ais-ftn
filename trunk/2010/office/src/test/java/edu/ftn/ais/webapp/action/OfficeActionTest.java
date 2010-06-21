package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import edu.ftn.ais.service.ClientManager;
import edu.ftn.ais.service.OfficeManager;
import edu.ftn.ais.model.Office;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class OfficeActionTest extends BaseActionTestCase {
    private OfficeAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new OfficeAction();
        OfficeManager officeManager = (OfficeManager) applicationContext.getBean("officeManager");
        action.setOfficeManager(officeManager);
    
        //neso
        ClientManager clientManager = (ClientManager) applicationContext.getBean("clientManager");
        
        // add a test office to the database
        Office office = new Office();

        // enter all required fields
        office.setAdresa("GoOjQaIsOsBgPlXxFdBcJoGvPmWmYrHuTaNoMmEaZlFzH");
        office.setGrad("MaElXhTnHxEhBfDcCyMkMgTbYxUuSjJjZhPlTcZiElSiL");
        office.setClient(clientManager.get(-1L));

        officeManager.save(office);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getOffices().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdoffice(-1L);
        assertNull(action.getOffice());
        assertEquals("success", action.edit());
        assertNotNull(action.getOffice());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdoffice(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getOffice());

        Office office = action.getOffice();
        // update required fields
        office.setAdresa("ErRnFsZtDnOaLwKkFdMiZpLmIkMcHfIvVuGvQxWmKuCdO");
        office.setGrad("QyVmMvVwCoNnAaEuYvOjGzNuKeRdWzIwBbFvIyTzKzEzI");

        action.setOffice(office);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Office office = new Office();
        office.setIdoffice(-2L);
        action.setOffice(office);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}