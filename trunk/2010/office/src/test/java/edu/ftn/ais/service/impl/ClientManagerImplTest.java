package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.ClientDao;
import edu.ftn.ais.model.Client;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientManagerImplTest extends BaseManagerMockTestCase {
    private ClientManagerImpl manager = null;
    private ClientDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(ClientDao.class);
        manager = new ClientManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetClient() {
        log.debug("testing get...");

        final Long idclient = 7L;
        final Client client = new Client();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idclient)));
            will(returnValue(client));
        }});

        Client result = manager.get(idclient);
        assertSame(client, result);
    }

    @Test
    public void testGetClients() {
        log.debug("testing getAll...");

        final List clients = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(clients));
        }});

        List result = manager.getAll();
        assertSame(clients, result);
    }

    @Test
    public void testSaveClient() {
        log.debug("testing save...");

        final Client client = new Client();
        // enter all required fields
        client.setDatumOsnivanja(new java.util.Date());
        client.setNaziv("KnDeOxIiLlQlVqGzOzTqHxDaF");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(client)));
        }});

        manager.save(client);
    }

    @Test
    public void testRemoveClient() {
        log.debug("testing remove...");

        final Long idclient = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idclient)));
        }});

        manager.remove(idclient);
    }
}