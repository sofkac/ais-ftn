package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.Angazovan;
import ftn.edu.ais.dao.AngazovanDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class AngazovanDaoHibernate extends GenericDaoHibernate<Angazovan, Long> implements AngazovanDao {

    public AngazovanDaoHibernate() {
        super(Angazovan.class);
    }
}
