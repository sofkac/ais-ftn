package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Roba;
import edu.ftn.ais.dao.RobaDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class RobaDaoHibernate extends GenericDaoHibernate<Roba, Long> implements RobaDao {

    public RobaDaoHibernate() {
        super(Roba.class);
    }
}
