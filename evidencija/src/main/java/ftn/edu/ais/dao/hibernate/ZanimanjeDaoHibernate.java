package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.Zanimanje;
import ftn.edu.ais.dao.ZanimanjeDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class ZanimanjeDaoHibernate extends GenericDaoHibernate<Zanimanje, Long> implements ZanimanjeDao {

    public ZanimanjeDaoHibernate() {
        super(Zanimanje.class);
    }
}
