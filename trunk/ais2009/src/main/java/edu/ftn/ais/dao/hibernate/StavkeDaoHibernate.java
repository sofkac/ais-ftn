package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Stavke;
import edu.ftn.ais.dao.StavkeDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class StavkeDaoHibernate extends GenericDaoHibernate<Stavke, Long> implements StavkeDao {

    public StavkeDaoHibernate() {
        super(Stavke.class);
    }
}
