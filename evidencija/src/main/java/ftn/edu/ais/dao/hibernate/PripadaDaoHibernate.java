package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.Pripada;
import ftn.edu.ais.dao.PripadaDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class PripadaDaoHibernate extends GenericDaoHibernate<Pripada, Long> implements PripadaDao {

    public PripadaDaoHibernate() {
        super(Pripada.class);
    }
}
