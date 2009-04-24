package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.TimDao;
import ftn.edu.ais.model.Tim;
import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimManagerImplTest extends BaseManagerMockTestCase {
    private TimManagerImpl manager = null;
    private TimDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(TimDao.class);
        manager = new TimManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetTim() {
        log.debug("testing get...");

        final Long idt = 7L;
        final Tim tim = new Tim();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idt)));
            will(returnValue(tim));
        }});

        Tim result = manager.get(idt);
        assertSame(tim, result);
    }

    @Test
    public void testGetTims() {
        log.debug("testing getAll...");

        final List tims = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(tims));
        }});

        List result = manager.getAll();
        assertSame(tims, result);
    }

    @Test
    public void testSaveTim() {
        log.debug("testing save...");

        final Tim tim = new Tim();
        // enter all required fields
        tim.setNazt("SeNsQhYhJrXsTePzBcYlOmRrEnAtDd");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(tim)));
        }});

        manager.save(tim);
    }

    @Test
    public void testRemoveTim() {
        log.debug("testing remove...");

        final Long idt = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idt)));
        }});

        manager.remove(idt);
    }
}