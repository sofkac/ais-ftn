package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.FakturaDao;
import edu.ftn.ais.model.Faktura;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class FakturaManagerImplTest extends BaseManagerMockTestCase {
    private FakturaManagerImpl manager = null;
    private FakturaDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(FakturaDao.class);
        manager = new FakturaManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetFaktura() {
        log.debug("testing get...");

        final Long idf = 7L;
        final Faktura faktura = new Faktura();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idf)));
            will(returnValue(faktura));
        }});

        Faktura result = manager.get(idf);
        assertSame(faktura, result);
    }

    @Test
    public void testGetFakturas() {
        log.debug("testing getAll...");

        final List fakturas = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(fakturas));
        }});

        List result = manager.getAll();
        assertSame(fakturas, result);
    }

    @Test
    public void testSaveFaktura() {
        log.debug("testing save...");

        final Faktura faktura = new Faktura();
        // enter all required fields
        faktura.setDatum(new java.util.Date());
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(faktura)));
        }});

        manager.save(faktura);
    }

    @Test
    public void testRemoveFaktura() {
        log.debug("testing remove...");

        final Long idf = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idf)));
        }});

        manager.remove(idf);
    }
}