package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import ftn.edu.ais.service.ZaposleniManager;
import ftn.edu.ais.model.Zaposleni;
import ftn.edu.ais.webapp.action.BaseAction;

import java.util.List;

public class ZaposleniAction extends BaseAction implements Preparable {
    private ZaposleniManager zaposleniManager;
    private List zaposlenies;
    private Zaposleni zaposleni;
    private Long  idz;

    public void setZaposleniManager(ZaposleniManager zaposleniManager) {
        this.zaposleniManager = zaposleniManager;
    }

    public List getZaposlenies() {
        return zaposlenies;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String zaposleniId = getRequest().getParameter("zaposleni.idz");
            if (zaposleniId != null && !zaposleniId.equals("")) {
                zaposleni = zaposleniManager.get(new Long(zaposleniId));
            }
        }
    }

    public String list() {
        zaposlenies = zaposleniManager.getAll();
        return SUCCESS;
    }

    public void setIdz(Long  idz) {
        this. idz =  idz;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public String delete() {
        zaposleniManager.remove(zaposleni.getIdz());
        saveMessage(getText("zaposleni.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idz != null) {
            zaposleni = zaposleniManager.get(idz);
        } else {
            zaposleni = new Zaposleni();
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

        boolean isNew = (zaposleni.getIdz() == null);

        zaposleniManager.save(zaposleni);

        String key = (isNew) ? "zaposleni.added" : "zaposleni.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}