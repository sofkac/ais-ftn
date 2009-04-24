package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import ftn.edu.ais.service.TimManager;
import ftn.edu.ais.model.Tim;
import ftn.edu.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class TimActionTest extends BaseActionTestCase {
    private TimAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new TimAction();
        TimManager timManager = (TimManager) applicationContext.getBean("timManager");
        action.setTimManager(timManager);
    
        // add a test tim to the database
        Tim tim = new Tim();

        // enter all required fields
        tim.setNazt("YmPaFfMmQpKyWeXtFaFxVqMpVgLaEq");

        timManager.save(tim);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getTims().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdt(-1L);
        assertNull(action.getTim());
        assertEquals("success", action.edit());
        assertNotNull(action.getTim());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdt(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getTim());

        Tim tim = action.getTim();
        // update required fields
        tim.setNazt("WxEpBlGfIdVkUrGoEqBsFwHkRvIaMl");

        action.setTim(tim);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Tim tim = new Tim();
        tim.setIdt(-2L);
        action.setTim(tim);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}