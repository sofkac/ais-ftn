package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.ZaposleniDao;
import ftn.edu.ais.model.Zaposleni;
import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZaposleniManagerImplTest extends BaseManagerMockTestCase {
    private ZaposleniManagerImpl manager = null;
    private ZaposleniDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(ZaposleniDao.class);
        manager = new ZaposleniManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetZaposleni() {
        log.debug("testing get...");

        final Long idz = 7L;
        final Zaposleni zaposleni = new Zaposleni();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idz)));
            will(returnValue(zaposleni));
        }});

        Zaposleni result = manager.get(idz);
        assertSame(zaposleni, result);
    }

    @Test
    public void testGetZaposlenies() {
        log.debug("testing getAll...");

        final List zaposlenies = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(zaposlenies));
        }});

        List result = manager.getAll();
        assertSame(zaposlenies, result);
    }

    @Test
    public void testSaveZaposleni() {
        log.debug("testing save...");

        final Zaposleni zaposleni = new Zaposleni();
        // enter all required fields
        zaposleni.setAdrz("MgJdCoHbXqKnBtFkZmMdHmZnJnTvPaWtZbUzRxQzZvOcXrHlPd");
        zaposleni.setGradz("WcDnHySwXdXoSxImPhGn");
        zaposleni.setImez("YmRhGaHeBbLhMyLbThWt");
        zaposleni.setJmbz("DoCtBgQsDmFoK");
        zaposleni.setMailz("DiXnHmPrIjHmOaYjBsRxNcNuGcRbMeOkBiIdTzDhUyOgIxVePi");
        zaposleni.setPrzz("MzHyLkZzQkKzXuEqBgZl");
        zaposleni.setTelz("FpLjVcLiZlPyFtH");
        zaposleni.setZipz("DpJqXuDtGl");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(zaposleni)));
        }});

        manager.save(zaposleni);
    }

    @Test
    public void testRemoveZaposleni() {
        log.debug("testing remove...");

        final Long idz = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idz)));
        }});

        manager.remove(idz);
    }
}