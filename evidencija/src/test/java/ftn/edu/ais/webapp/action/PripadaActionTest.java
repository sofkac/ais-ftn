package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import ftn.edu.ais.service.PripadaManager;
import ftn.edu.ais.service.TimManager;//dodato
import ftn.edu.ais.service.ZanimanjeManager;//dodato

import ftn.edu.ais.model.Pripada;
import ftn.edu.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class PripadaActionTest extends BaseActionTestCase {
    private PripadaAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new PripadaAction();
        PripadaManager pripadaManager = (PripadaManager) applicationContext.getBean("pripadaManager");
        action.setPripadaManager(pripadaManager);
        
        // added by Sofija :)
		TimManager timManager = (TimManager) applicationContext.getBean("timManager");
		ZanimanjeManager zanimanjeManager = (ZanimanjeManager) applicationContext.getBean("zanimanjeManager");
		//end
    
        // add a test pripada to the database
        Pripada pripada = new Pripada();

        // enter all required fields
        pripada.setBrlj(new Long("5"));
        
        pripada.setTim(timManager.get(-1L));//dodato
	pripada.setZanimanje(zanimanjeManager.get(-1L));//dodato

        pripadaManager.save(pripada);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getPripadas().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdp(-1L);
        assertNull(action.getPripada());
        assertEquals("success", action.edit());
        assertNotNull(action.getPripada());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdp(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getPripada());

        Pripada pripada = action.getPripada();
        // update required fields
        pripada.setBrlj(new Long("8"));

        action.setPripada(pripada);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Pripada pripada = new Pripada();
        pripada.setIdp(-2L);
        action.setPripada(pripada);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}