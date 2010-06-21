package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Office;
import edu.ftn.ais.dao.OfficeDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class OfficeDaoHibernate extends GenericDaoHibernate<Office, Long> implements OfficeDao {

    public OfficeDaoHibernate() {
        super(Office.class);
    }
}
