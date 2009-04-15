package edu.ftn.ais.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ftn.ais.dao.StavkeDao;
import edu.ftn.ais.model.Stavke;
import edu.ftn.ais.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class StavkeManagerImplTest extends BaseManagerMockTestCase {
    private StavkeManagerImpl manager = null;
    private StavkeDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(StavkeDao.class);
        manager = new StavkeManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetStavke() {
        log.debug("testing get...");

        final Long ids = 7L;
        final Stavke stavke = new Stavke();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(ids)));
            will(returnValue(stavke));
        }});

        Stavke result = manager.get(ids);
        assertSame(stavke, result);
    }

    @Test
    public void testGetStavkes() {
        log.debug("testing getAll...");

        final List stavkes = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(stavkes));
        }});

        List result = manager.getAll();
        assertSame(stavkes, result);
    }

    @Test
    public void testSaveStavke() {
        log.debug("testing save...");

        final Stavke stavke = new Stavke();
        // enter all required fields
        stavke.setKolicina("FkXlRvWvMzWpOyPhBjImIwIqWcFfBxCyYwCtOdAdWhXmQvNlXqLbVzZcSkPyItCcCsUeFlPcGxXfMpCqPrPcMoJsOpDtGvChSgEvIdZuTrIwNlMePcCxYqFaAxEvIdGoMwNlOvVtWhZsJlPvMlHqVnCuRmWhDcHvRwWeBzWuLqSfHqMwWuXtShRmSoKyIaOuSaZqOuTiXqBjUjFwJqPnTdDfShIiTaNxTzRdCmGqTuOeNpQbYgAfJkDqTrItBgD");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(stavke)));
        }});

        manager.save(stavke);
    }

    @Test
    public void testRemoveStavke() {
        log.debug("testing remove...");

        final Long ids = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(ids)));
        }});

        manager.remove(ids);
    }
}