package ftn.edu.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import ftn.edu.ais.dao.ZanimanjeDao;
import ftn.edu.ais.model.Zanimanje;
import ftn.edu.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZanimanjeManagerImplTest extends BaseManagerMockTestCase {
    private ZanimanjeManagerImpl manager = null;
    private ZanimanjeDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(ZanimanjeDao.class);
        manager = new ZanimanjeManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetZanimanje() {
        log.debug("testing get...");

        final Long idzan = 7L;
        final Zanimanje zanimanje = new Zanimanje();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idzan)));
            will(returnValue(zanimanje));
        }});

        Zanimanje result = manager.get(idzan);
        assertSame(zanimanje, result);
    }

    @Test
    public void testGetZanimanjes() {
        log.debug("testing getAll...");

        final List zanimanjes = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(zanimanjes));
        }});

        List result = manager.getAll();
        assertSame(zanimanjes, result);
    }

    @Test
    public void testSaveZanimanje() {
        log.debug("testing save...");

        final Zanimanje zanimanje = new Zanimanje();
        // enter all required fields
        zanimanje.setNazzan("QuWlZaIyYvOsNgRiTiMkDmWmTuNiWw");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(zanimanje)));
        }});

        manager.save(zanimanje);
    }

    @Test
    public void testRemoveZanimanje() {
        log.debug("testing remove...");

        final Long idzan = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idzan)));
        }});

        manager.remove(idzan);
    }
}