package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.OsobljeDao;
import edu.ftn.ais.model.Osoblje;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class OsobljeManagerImplTest extends BaseManagerMockTestCase {
    private OsobljeManagerImpl manager = null;
    private OsobljeDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(OsobljeDao.class);
        manager = new OsobljeManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetOsoblje() {
        log.debug("testing get...");

        final Long osobljeID = 7L;
        final Osoblje osoblje = new Osoblje();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(osobljeID)));
            will(returnValue(osoblje));
        }});

        Osoblje result = manager.get(osobljeID);
        assertSame(osoblje, result);
    }

    @Test
    public void testGetOsobljes() {
        log.debug("testing getAll...");

        final List osobljes = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(osobljes));
        }});

        List result = manager.getAll();
        assertSame(osobljes, result);
    }

    @Test
    public void testSaveOsoblje() {
        log.debug("testing save...");

        final Osoblje osoblje = new Osoblje();
        // enter all required fields
        osoblje.setIme("FaHjUiMrUcHcQbRwQfAs");
        osoblje.setPrezime("QpEbUoKdUrDrEmKpMlTxLbMjN");
        osoblje.setVrsta(13728192233580859L);
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(osoblje)));
        }});

        manager.save(osoblje);
    }

    @Test
    public void testRemoveOsoblje() {
        log.debug("testing remove...");

        final Long osobljeID = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(osobljeID)));
        }});

        manager.remove(osobljeID);
    }
}