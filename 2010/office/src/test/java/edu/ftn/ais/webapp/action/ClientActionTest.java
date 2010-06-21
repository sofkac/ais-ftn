package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.ftn.ais.service.ClientManager;
import edu.ftn.ais.model.Client;
import edu.ftn.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class ClientActionTest extends BaseActionTestCase {
    private ClientAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new ClientAction();
        ClientManager clientManager = (ClientManager) applicationContext.getBean("clientManager");
        action.setClientManager(clientManager);
    
        // add a test client to the database
        Client client = new Client();

        // enter all required fields
        client.setDatumOsnivanja(new java.util.Date());
        client.setNaziv("KxOnTkWtEdAaIbKjJePsUlBkR");

        clientManager.save(client);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getClients().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdclient(-1L);
        assertNull(action.getClient());
        assertEquals("success", action.edit());
        assertNotNull(action.getClient());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdclient(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getClient());

        Client client = action.getClient();
        // update required fields
        client.setDatumOsnivanja(new java.util.Date());
        client.setNaziv("SuObKmNhIfSkAzPyDzAmUlRuS");

        action.setClient(client);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Client client = new Client();
        client.setIdclient(-2L);
        action.setClient(client);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}