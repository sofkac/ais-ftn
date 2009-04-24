package ftn.edu.ais.dao.hibernate;

import ftn.edu.ais.model.Zaposleni;
import ftn.edu.ais.dao.ZaposleniDao;
import ftn.edu.ais.dao.hibernate.GenericDaoHibernate;

public class ZaposleniDaoHibernate extends GenericDaoHibernate<Zaposleni, Long> implements ZaposleniDao {

    public ZaposleniDaoHibernate() {
        super(Zaposleni.class);
    }
}
