package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.Tim;
import ftn.edu.ais.dao.TimDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class TimDaoHibernate extends GenericDaoHibernate<Tim, Long> implements TimDao {

    public TimDaoHibernate() {
        super(Tim.class);
    }
}
