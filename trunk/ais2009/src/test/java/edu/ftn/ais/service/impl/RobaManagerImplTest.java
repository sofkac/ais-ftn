package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.RobaDao;
import edu.ftn.ais.model.Roba;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class RobaManagerImplTest extends BaseManagerMockTestCase {
    private RobaManagerImpl manager = null;
    private RobaDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(RobaDao.class);
        manager = new RobaManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetRoba() {
        log.debug("testing get...");

        final Long idr = 7L;
        final Roba roba = new Roba();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idr)));
            will(returnValue(roba));
        }});

        Roba result = manager.get(idr);
        assertSame(roba, result);
    }

    @Test
    public void testGetRobas() {
        log.debug("testing getAll...");

        final List robas = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(robas));
        }});

        List result = manager.getAll();
        assertSame(robas, result);
    }

    @Test
    public void testSaveRoba() {
        log.debug("testing save...");

        final Roba roba = new Roba();
        // enter all required fields
        roba.setJm("UaKlYsVaFm");
        roba.setKolicina(1.5858448516606665E9L);
        roba.setNaziv("ViClYuVwCfFhZoGhKnHrOcTlWfBfEaQuVrLjSiQeWoOtKfZeCx");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(roba)));
        }});

        manager.save(roba);
    }

    @Test
    public void testRemoveRoba() {
        log.debug("testing remove...");

        final Long idr = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idr)));
        }});

        manager.remove(idr);
    }
}