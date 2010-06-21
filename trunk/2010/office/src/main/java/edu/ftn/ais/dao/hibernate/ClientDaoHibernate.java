package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Client;
import edu.ftn.ais.dao.ClientDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class ClientDaoHibernate extends GenericDaoHibernate<Client, Long> implements ClientDao {

    public ClientDaoHibernate() {
        super(Client.class);
    }
}
