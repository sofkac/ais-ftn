package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Polaznik;
import edu.ftn.ais.dao.PolaznikDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class PolaznikDaoHibernate extends GenericDaoHibernate<Polaznik, Long> implements PolaznikDao {

    public PolaznikDaoHibernate() {
        super(Polaznik.class);
    }
}
