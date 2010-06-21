package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.OfficeDao;
import edu.ftn.ais.model.Office;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class OfficeManagerImplTest extends BaseManagerMockTestCase {
    private OfficeManagerImpl manager = null;
    private OfficeDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(OfficeDao.class);
        manager = new OfficeManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetOffice() {
        log.debug("testing get...");

        final Long idoffice = 7L;
        final Office office = new Office();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(idoffice)));
            will(returnValue(office));
        }});

        Office result = manager.get(idoffice);
        assertSame(office, result);
    }

    @Test
    public void testGetOffices() {
        log.debug("testing getAll...");

        final List offices = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(offices));
        }});

        List result = manager.getAll();
        assertSame(offices, result);
    }

    @Test
    public void testSaveOffice() {
        log.debug("testing save...");

        final Office office = new Office();
        // enter all required fields
        office.setAdresa("IqBoVrKpDlRiWfTmUhTzHeZdPyHjVrCxRlYsUqBlEeVvK");
        office.setGrad("VdKnIjBpIrFlJuBuIbBnVnXuCdWdXlWzWdLhQtItZjVnD");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(office)));
        }});

        manager.save(office);
    }

    @Test
    public void testRemoveOffice() {
        log.debug("testing remove...");

        final Long idoffice = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(idoffice)));
        }});

        manager.remove(idoffice);
    }
}