package edu.ftn.ais.dao;

import edu.ftn.ais.dao.BaseDaoTestCase;
import edu.ftn.ais.model.Client;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class ClientDaoTest extends BaseDaoTestCase {
    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void testAddAndRemoveClient() throws Exception {
        Client client = new Client();

        // enter all required fields
        client.setDatumOsnivanja(new java.util.Date());
        client.setNaziv("SvHtGgLiIjSiOpLoWeKwFvSoW");

        log.debug("adding client...");
        client = clientDao.save(client);

        client = clientDao.get(client.getIdclient());

        assertNotNull(client.getIdclient());

        log.debug("removing client...");

        clientDao.remove(client.getIdclient());

        try {
            clientDao.get(client.getIdclient());
            fail("Client found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}