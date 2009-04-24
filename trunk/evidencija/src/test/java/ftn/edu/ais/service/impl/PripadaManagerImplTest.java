package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.PripadaDao;
import ftn.edu.ais.model.Pripada;
import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PripadaManagerImplTest extends BaseManagerMockTestCase {
    private PripadaManagerImpl manager = null;
    private PripadaDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(PripadaDao.class);
        manager = new PripadaManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPripada() {
        log.debug("testing get...");

        final Long idp = 7L;
        final Pripada pripada = new Pripada();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idp)));
            will(returnValue(pripada));
        }});

        Pripada result = manager.get(idp);
        assertSame(pripada, result);
    }

    @Test
    public void testGetPripadas() {
        log.debug("testing getAll...");

        final List pripadas = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(pripadas));
        }});

        List result = manager.getAll();
        assertSame(pripadas, result);
    }

    @Test
    public void testSavePripada() {
        log.debug("testing save...");

        final Pripada pripada = new Pripada();
        // enter all required fields
        pripada.setBrlj(new Long("1"));
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(pripada)));
        }});

        manager.save(pripada);
    }

    @Test
    public void testRemovePripada() {
        log.debug("testing remove...");

        final Long idp = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idp)));
        }});

        manager.remove(idp);
    }
}