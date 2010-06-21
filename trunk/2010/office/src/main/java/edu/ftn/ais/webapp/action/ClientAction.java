package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.ClientManager;
import edu.ftn.ais.model.Client;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class ClientAction extends BaseAction implements Preparable {
    private ClientManager clientManager;
    private List clients;
    private Client client;
    private Long  idclient;

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public List getClients() {
        return clients;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String clientId = getRequest().getParameter("client.idclient");
            if (clientId != null && !clientId.equals("")) {
                client = clientManager.get(new Long(clientId));
            }
        }
    }

    public String list() {
        clients = clientManager.getAll();
        return SUCCESS;
    }

    public void setIdclient(Long  idclient) {
        this. idclient =  idclient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String delete() {
        clientManager.remove(client.getIdclient());
        saveMessage(getText("client.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idclient != null) {
            client = clientManager.get(idclient);
        } else {
            client = new Client();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (client.getIdclient() == null);

        clientManager.save(client);

        String key = (isNew) ? "client.added" : "client.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}