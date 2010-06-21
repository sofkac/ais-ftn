package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.CasoviDao;
import edu.ftn.ais.model.Casovi;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CasoviManagerImplTest extends BaseManagerMockTestCase {
    private CasoviManagerImpl manager = null;
    private CasoviDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(CasoviDao.class);
        manager = new CasoviManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetCasovi() {
        log.debug("testing get...");

        final Long idCas = 7L;
        final Casovi casovi = new Casovi();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idCas)));
            will(returnValue(casovi));
        }});

        Casovi result = manager.get(idCas);
        assertSame(casovi, result);
    }

    @Test
    public void testGetCasovies() {
        log.debug("testing getAll...");

        final List casovies = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(casovies));
        }});

        List result = manager.getAll();
        assertSame(casovies, result);
    }

    @Test
    public void testSaveCasovi() {
        log.debug("testing save...");

        final Casovi casovi = new Casovi();
        // enter all required fields
        casovi.setDatumCasa(new java.util.Date());
        casovi.setStatus(400989963189748L);
        casovi.setVremeDo("9:00:00");
        casovi.setVremeOd("19:00:00");
        casovi.setVrsta(762912698414968L);
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(casovi)));
        }});

        manager.save(casovi);
    }

    @Test
    public void testRemoveCasovi() {
        log.debug("testing remove...");

        final Long idCas = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idCas)));
        }});

        manager.remove(idCas);
    }
}