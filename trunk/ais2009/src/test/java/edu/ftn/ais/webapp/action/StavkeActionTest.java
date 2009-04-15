package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.StavkeManager;
import edu.ftn.ais.model.Stavke;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class StavkeActionTest extends BaseActionTestCase {
    private StavkeAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new StavkeAction();
        StavkeManager stavkeManager = (StavkeManager) applicationContext.getBean("stavkeManager");
        action.setStavkeManager(stavkeManager);
    
        // add a test stavke to the database
        Stavke stavke = new Stavke();

        // enter all required fields
        stavke.setKolicina("VrDjGsWsOjQtRkAwRmYsWfSvIxBbXpIwZfQsNsUnNvWaUcUnVkUsZjByGsDoJgVuNlVrLtJiOiCiWnWqJbRzYsPrRcKlVsHuHkPuUsCwVoPeDxSlHrHlBvOcCmItYgLiEbJpEgHrIoQcKuXtWfUaPsAlQdLvCcLeXlBnQeUnRmRbMoEkWyGcFgPjLvZmZuSpSbMtWkBlHeYjExSxBoTbQlWhSsOpMjRqNrVpHzGwYhOvAySmWoNfKgDnKhEqYrY");

        stavkeManager.save(stavke);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getStavkes().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIds(-1L);
        assertNull(action.getStavke());
        assertEquals("success", action.edit());
        assertNotNull(action.getStavke());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIds(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getStavke());

        Stavke stavke = action.getStavke();
        // update required fields
        stavke.setKolicina("ThEkXrOqCjJjUaFfFkSjWfMtXxYlPqMwPpQxWxRqTdOmAxByStWiWcBfLiNeIlGaHoYoByXiYuZyIeItOhCtAgKxRhCyYtLdMwJsNcUaJjHjRzJdNpVfDuGwKeEjIuFiHeNsOpFoNcFiNpYxRiPgBxMzWeByKxWmVsKvGfXdQdTpKyUjTnPuCiMdZbLdAiFuNdCsMmJcKxGsQlGkEyChQwJaUsHkNhPuLqEwHuYjHlZaPxCfUzHuZjZvJmVwOyO");

        action.setStavke(stavke);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Stavke stavke = new Stavke();
        stavke.setIds(-2L);
        action.setStavke(stavke);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}