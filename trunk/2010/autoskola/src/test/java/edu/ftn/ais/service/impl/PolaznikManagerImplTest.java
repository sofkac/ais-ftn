package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.PolaznikDao;
import edu.ftn.ais.model.Polaznik;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PolaznikManagerImplTest extends BaseManagerMockTestCase {
    private PolaznikManagerImpl manager = null;
    private PolaznikDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(PolaznikDao.class);
        manager = new PolaznikManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPolaznik() {
        log.debug("testing get...");

        final Long idpolaznik = 7L;
        final Polaznik polaznik = new Polaznik();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idpolaznik)));
            will(returnValue(polaznik));
        }});

        Polaznik result = manager.get(idpolaznik);
        assertSame(polaznik, result);
    }

    @Test
    public void testGetPolazniks() {
        log.debug("testing getAll...");

        final List polazniks = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(polazniks));
        }});

        List result = manager.getAll();
        assertSame(polazniks, result);
    }

    @Test
    public void testSavePolaznik() {
        log.debug("testing save...");

        final Polaznik polaznik = new Polaznik();
        // enter all required fields
        polaznik.setIme("EfUgByPfTyItYvUrQqKp");
        polaznik.setPrezime("WkZrSeEqYhOqSeYcNtTcAhFjX");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(polaznik)));
        }});

        manager.save(polaznik);
    }

    @Test
    public void testRemovePolaznik() {
        log.debug("testing remove...");

        final Long idpolaznik = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idpolaznik)));
        }});

        manager.remove(idpolaznik);
    }
}