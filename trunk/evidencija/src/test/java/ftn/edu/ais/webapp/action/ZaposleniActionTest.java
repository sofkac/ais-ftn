package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import ftn.edu.ais.service.ZanimanjeManager;//dodato
import ftn.edu.ais.service.ZaposleniManager;
import ftn.edu.ais.model.Zaposleni;
import ftn.edu.ais.webapp.action.BaseActionTestCase;
import org.springframework.mock.web.MockHttpServletRequest;

public class ZaposleniActionTest extends BaseActionTestCase {
    private ZaposleniAction action;

    @Override @SuppressWarnings("unchecked")
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new ZaposleniAction();
        ZaposleniManager zaposleniManager = (ZaposleniManager) applicationContext.getBean("zaposleniManager");
        action.setZaposleniManager(zaposleniManager);
        
        //added by Sofija :)
        ZanimanjeManager zanimanjeManager = (ZanimanjeManager) applicationContext.getBean("zanimanjeManager");
        //end
    
        // add a test zaposleni to the database
        Zaposleni zaposleni = new Zaposleni();

        // enter all required fields
        zaposleni.setAdrz("KmIbBvVvWxIjOqMtSpElPnVrOjHkUmXjExKnXvCiFyAqNcGzKy");
        zaposleni.setGradz("KlJhRdIqIwPvIgAfYwPi");
        zaposleni.setImez("UhWlSeBsIqRqSeRgJxIk");
        //added by neso
        String tmpJmbz = (""+ Math.random()).substring(0, 12);
        zaposleni.setJmbz(tmpJmbz);
        zaposleni.setMailz("TiRvHpMgJdYhCtBdHoCjJbHzOxRnDgZvIgJsRiEkAkKaBpUdHx");
        zaposleni.setPrzz("SsWbYuFlVkTrCeHmFvUt");
        zaposleni.setTelz("TeErMkEhHfWmIcP");
        zaposleni.setZipz("KtQdRgWnIn");
        zaposleni.setZanimanje(zanimanjeManager.get(-1L));//dodato

        zaposleniManager.save(zaposleni);
    }

    public void testSearch() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getZaposlenies().size() >= 1);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setIdz(-1L);
        assertNull(action.getZaposleni());
        assertEquals("success", action.edit());
        assertNotNull(action.getZaposleni());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setIdz(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getZaposleni());

        Zaposleni zaposleni = action.getZaposleni();
        // update required fields
        zaposleni.setAdrz("CfPqLtPaJyUoBaXdVjIiQxRdMrCxTvQjUuAnNfMkDsWvFgChXv");
        zaposleni.setGradz("RaWyFqNcSqVoZgTlFkRh");
        zaposleni.setImez("OlKpSwKaTsHbYrChJhFt");
        zaposleni.setJmbz("JnKaWzSqEiOpH");
        zaposleni.setMailz("UuOrUrEpWcRtWrQbCsNxTbFgFtScVjYrHiEpMvIcAsNiEwZkWh");
        zaposleni.setPrzz("RbIoCyRsWnErWnLuGgEd");
        zaposleni.setTelz("RvWoGzVnWxFiPfI");
        zaposleni.setZipz("EbSkTpEtLo");

        action.setZaposleni(zaposleni);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Zaposleni zaposleni = new Zaposleni();
        zaposleni.setIdz(-2L);
        action.setZaposleni(zaposleni);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}