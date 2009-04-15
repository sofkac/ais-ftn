package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.KlijentManager;
import edu.ftn.ais.model.Klijent;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class KlijentAction extends BaseAction implements Preparable {
    private KlijentManager klijentManager;
    private List klijents;
    private Klijent klijent;
    private Long  idk;

    public void setKlijentManager(KlijentManager klijentManager) {
        this.klijentManager = klijentManager;
    }

    public List getKlijents() {
        return klijents;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String klijentId = getRequest().getParameter("klijent.idk");
            if (klijentId != null && !klijentId.equals("")) {
                klijent = klijentManager.get(new Long(klijentId));
            }
        }
    }

    public String list() {
        klijents = klijentManager.getAll();
        return SUCCESS;
    }

    public void setIdk(Long  idk) {
        this. idk =  idk;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public String delete() {
        klijentManager.remove(klijent.getIdk());
        saveMessage(getText("klijent.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idk != null) {
            klijent = klijentManager.get(idk);
        } else {
            klijent = new Klijent();
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

        boolean isNew = (klijent.getIdk() == null);

        klijentManager.save(klijent);

        String key = (isNew) ? "klijent.added" : "klijent.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}