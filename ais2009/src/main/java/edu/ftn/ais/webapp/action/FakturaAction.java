package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.FakturaManager;
import edu.ftn.ais.model.Faktura;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class FakturaAction extends BaseAction implements Preparable {
    private FakturaManager fakturaManager;
    private List fakturas;
    private Faktura faktura;
    private Long  idf;

    public void setFakturaManager(FakturaManager fakturaManager) {
        this.fakturaManager = fakturaManager;
    }

    public List getFakturas() {
        return fakturas;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String fakturaId = getRequest().getParameter("faktura.idf");
            if (fakturaId != null && !fakturaId.equals("")) {
                faktura = fakturaManager.get(new Long(fakturaId));
            }
        }
    }

    public String list() {
        fakturas = fakturaManager.getAll();
        return SUCCESS;
    }

    public void setIdf(Long  idf) {
        this. idf =  idf;
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public String delete() {
        fakturaManager.remove(faktura.getIdf());
        saveMessage(getText("faktura.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idf != null) {
            faktura = fakturaManager.get(idf);
        } else {
            faktura = new Faktura();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (faktura.getIdf() == null);

        fakturaManager.save(faktura);

        String key = (isNew) ? "faktura.added" : "faktura.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}