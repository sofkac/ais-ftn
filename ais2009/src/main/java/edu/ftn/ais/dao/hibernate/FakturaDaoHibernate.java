package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Faktura;
import edu.ftn.ais.dao.FakturaDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class FakturaDaoHibernate extends GenericDaoHibernate<Faktura, Long> implements FakturaDao {

    public FakturaDaoHibernate() {
        super(Faktura.class);
    }
}
