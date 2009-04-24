package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import ftn.edu.ais.service.AngazovanManager;
import ftn.edu.ais.service.PripadaManager;//dodato
import ftn.edu.ais.service.ZaposleniManager;//dodato

import ftn.edu.ais.model.Angazovan;
import ftn.edu.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class AngazovanActionTest extends BaseActionTestCase {
    private AngazovanAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new AngazovanAction();
        AngazovanManager angazovanManager = (AngazovanManager) applicationContext.getBean("angazovanManager");
        action.setAngazovanManager(angazovanManager);
        
        // added by Sofija :)
		ZaposleniManager zaposleniManager = (ZaposleniManager) applicationContext.getBean("zaposleniManager");
		PripadaManager pripadaManager = (PripadaManager) applicationContext.getBean("pripadaManager");
		//end
    
        // add a test angazovan to the database
        Angazovan angazovan = new Angazovan();

        // enter all required fields
        
        angazovan.setZaposleni(zaposleniManager.get(-1L));//dodato
	angazovan.setPripada(pripadaManager.get(-1L));//dodato

        angazovanManager.save(angazovan);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getAngazovans().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIda(-1L);
        assertNull(action.getAngazovan());
        assertEquals("success", action.edit());
        assertNotNull(action.getAngazovan());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIda(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getAngazovan());

        Angazovan angazovan = action.getAngazovan();
        // update required fields

        action.setAngazovan(angazovan);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Angazovan angazovan = new Angazovan();
        angazovan.setIda(-2L);
        action.setAngazovan(angazovan);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}