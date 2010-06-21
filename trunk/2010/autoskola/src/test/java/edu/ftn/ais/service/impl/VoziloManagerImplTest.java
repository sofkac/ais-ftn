package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.VoziloDao;
import edu.ftn.ais.model.Vozilo;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class VoziloManagerImplTest extends BaseManagerMockTestCase {
    private VoziloManagerImpl manager = null;
    private VoziloDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(VoziloDao.class);
        manager = new VoziloManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetVozilo() {
        log.debug("testing get...");

        final Long voziloID = 7L;
        final Vozilo vozilo = new Vozilo();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(voziloID)));
            will(returnValue(vozilo));
        }});

        Vozilo result = manager.get(voziloID);
        assertSame(vozilo, result);
    }

    @Test
    public void testGetVoziloes() {
        log.debug("testing getAll...");

        final List voziloes = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(voziloes));
        }});

        List result = manager.getAll();
        assertSame(voziloes, result);
    }

    @Test
    public void testSaveVozilo() {
        log.debug("testing save...");

        final Vozilo vozilo = new Vozilo();
        // enter all required fields
        vozilo.setMarka("PtSxXjShFjWjLvUtOlOjPfMyHfChPpPhBaRlYxDlGdTxV");
        vozilo.setModel("KlGpUpBpGpJyVeWjMiIlMpZsYxQiFeBdLiBrStWhMqDjP");
        vozilo.setRegBroj("MwGfCiJzJa");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(vozilo)));
        }});

        manager.save(vozilo);
    }

    @Test
    public void testRemoveVozilo() {
        log.debug("testing remove...");

        final Long voziloID = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(voziloID)));
        }});

        manager.remove(voziloID);
    }
}