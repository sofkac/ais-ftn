package edu.ftn.ais.service.impl;

import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ftn.ais.dao.PlacanjaDao;
import edu.ftn.ais.model.Placanja;

public class PlacanjaManagerImplTest extends BaseManagerMockTestCase {
    private PlacanjaManagerImpl manager = null;
    private PlacanjaDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(PlacanjaDao.class);
        manager = new PlacanjaManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPlacanja() {
        log.debug("testing get...");

        final Long idplacanje = 7L;
        final Placanja placanja = new Placanja();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idplacanje)));
            will(returnValue(placanja));
        }});

        Placanja result = manager.get(idplacanje);
        assertSame(placanja, result);
    }

    @Test
    public void testGetPlacanjas() {
        log.debug("testing getAll...");

        final List placanjas = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(placanjas));
        }});

        List result = manager.getAll();
        assertSame(placanjas, result);
    }

    @Test
    public void testSavePlacanja() {
        log.debug("testing save...");

        final Placanja placanja = new Placanja();
        // enter all required fields
        placanja.setDate(new java.util.Date());
        placanja.setIznos(new BigDecimal("34.65"));
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(placanja)));
        }});

        manager.save(placanja);
    }

    @Test
    public void testRemovePlacanja() {
        log.debug("testing remove...");

        final Long idplacanje = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idplacanje)));
        }});

        manager.remove(idplacanje);
    }
}