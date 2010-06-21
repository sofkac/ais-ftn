package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Casovi;
import edu.ftn.ais.dao.CasoviDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class CasoviDaoHibernate extends GenericDaoHibernate<Casovi, Long> implements CasoviDao {

    public CasoviDaoHibernate() {
        super(Casovi.class);
    }
}
