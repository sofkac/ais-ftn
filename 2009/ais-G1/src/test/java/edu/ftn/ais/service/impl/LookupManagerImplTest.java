package edu.ftn.ais.service.impl;

import edu.ftn.ais.dao.LookupDao;
import edu.ftn.ais.model.Role;
import edu.ftn.ais.model.LabelValue;
import edu.ftn.ais.Constants;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class LookupManagerImplTest extends BaseManagerMockTestCase {
    private LookupManagerImpl mgr = new LookupManagerImpl();
    private LookupDao lookupDao = null;

    @Before
    public void setUp() throws Exception {
        lookupDao = context.mock(LookupDao.class);
        mgr.setLookupDao(lookupDao);
    }

    @Test
    public void testGetAllRoles() {
        log.debug("entered 'testGetAllRoles' method");

        // set expected behavior on dao
        Role role = new Role(Constants.ADMIN_ROLE);
        final List<Role> testData = new ArrayList<Role>();
        testData.add(role);
        context.checking(new Expectations() {{
            one(lookupDao).getRoles();
            will(returnValue(testData));
        }});

        List<LabelValue> roles = mgr.getAllRoles();
        assertTrue(roles.size() > 0);
    }
}
