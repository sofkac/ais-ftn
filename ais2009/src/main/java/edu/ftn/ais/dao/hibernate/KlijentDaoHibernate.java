package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Klijent;
import edu.ftn.ais.dao.KlijentDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class KlijentDaoHibernate extends GenericDaoHibernate<Klijent, Long> implements KlijentDao {

    public KlijentDaoHibernate() {
        super(Klijent.class);
    }
}
