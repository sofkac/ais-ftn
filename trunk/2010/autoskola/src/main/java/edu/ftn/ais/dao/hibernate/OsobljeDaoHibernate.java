package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Osoblje;
import edu.ftn.ais.dao.OsobljeDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class OsobljeDaoHibernate extends GenericDaoHibernate<Osoblje, Long> implements OsobljeDao {

    public OsobljeDaoHibernate() {
        super(Osoblje.class);
    }
}
