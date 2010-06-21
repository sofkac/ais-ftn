package edu.ftn.ais.dao.hibernate;

import edu.ftn.ais.model.Placanja;
import edu.ftn.ais.dao.PlacanjaDao;
import edu.ftn.ais.dao.hibernate.GenericDaoHibernate;

public class PlacanjaDaoHibernate extends GenericDaoHibernate<Placanja, Long> implements PlacanjaDao {

    public PlacanjaDaoHibernate() {
        super(Placanja.class);
    }
}
