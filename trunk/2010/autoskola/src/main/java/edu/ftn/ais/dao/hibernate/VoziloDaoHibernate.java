package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Vozilo;
import edu.ftn.ais.dao.VoziloDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class VoziloDaoHibernate extends GenericDaoHibernate<Vozilo, Long> implements VoziloDao {

    public VoziloDaoHibernate() {
        super(Vozilo.class);
    }
}
