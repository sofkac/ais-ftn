package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.AngazovanDao;
import ftn.edu.ais.model.Angazovan;
import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AngazovanManagerImplTest extends BaseManagerMockTestCase {
    private AngazovanManagerImpl manager = null;
    private AngazovanDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(AngazovanDao.class);
        manager = new AngazovanManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetAngazovan() {
        log.debug("testing get...");

        final Long ida = 7L;
        final Angazovan angazovan = new Angazovan();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(ida)));
            will(returnValue(angazovan));
        }});

        Angazovan result = manager.get(ida);
        assertSame(angazovan, result);
    }

    @Test
    public void testGetAngazovans() {
        log.debug("testing getAll...");

        final List angazovans = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(angazovans));
        }});

        List result = manager.getAll();
        assertSame(angazovans, result);
    }

    @Test
    public void testSaveAngazovan() {
        log.debug("testing save...");

        final Angazovan angazovan = new Angazovan();
        // enter all required fields
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(angazovan)));
        }});

        manager.save(angazovan);
    }

    @Test
    public void testRemoveAngazovan() {
        log.debug("testing remove...");

        final Long ida = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(ida)));
        }});

        manager.remove(ida);
    }
}