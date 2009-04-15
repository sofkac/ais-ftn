package edu.ftn.ais.service.impl;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ftn.ais.dao.KlijentDao;
import edu.ftn.ais.model.Klijent;

public class KlijentManagerImplTest extends BaseManagerMockTestCase {
    private KlijentManagerImpl manager = null;
    private KlijentDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(KlijentDao.class);
        manager = new KlijentManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetKlijent() {
        log.debug("testing get...");

        final Long idk = 7L;
        final Klijent klijent = new Klijent();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idk)));
            will(returnValue(klijent));
        }});

        Klijent result = manager.get(idk);
        assertSame(klijent, result);
    }

    @Test
    public void testGetKlijents() {
        log.debug("testing getAll...");

        final List klijents = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(klijents));
        }});

        List result = manager.getAll();
        assertSame(klijents, result);
    }

    @Test
    public void testSaveKlijent() {
        log.debug("testing save...");

        final Klijent klijent = new Klijent();
        // enter all required fields
        klijent.setAdresa("VgToIeQoHuRsFcGuFfClGcTbKeJwZbBeLbJwXdWcXiXxV");
        klijent.setMesto("VeJmTeXaDcImUbCtLkXrFyBnX");
        klijent.setNaziv("ReSnCcVtWhBoMiNfObHvLsCnGkCdJiStQqSmKaVuEyVqH");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(klijent)));
        }});

        manager.save(klijent);
    }

    @Test
    public void testRemoveKlijent() {
        log.debug("testing remove...");

        final Long idk = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idk)));
        }});

        manager.remove(idk);
    }
}