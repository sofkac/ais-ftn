package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.PolaznikManager;
import edu.ftn.ais.model.Polaznik;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class PolaznikAction extends BaseAction implements Preparable {
    private PolaznikManager polaznikManager;
    private List polazniks;
    private Polaznik polaznik;
    private Long  idpolaznik;

    public void setPolaznikManager(PolaznikManager polaznikManager) {
        this.polaznikManager = polaznikManager;
    }

    public List getPolazniks() {
        return polazniks;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String polaznikId = getRequest().getParameter("polaznik.idpolaznik");
            if (polaznikId != null && !polaznikId.equals("")) {
                polaznik = polaznikManager.get(new Long(polaznikId));
            }
        }
    }

    public String list() {
        polazniks = polaznikManager.getAll();
        return SUCCESS;
    }

    public void setIdpolaznik(Long  idpolaznik) {
        this. idpolaznik =  idpolaznik;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public String delete() {
        polaznikManager.remove(polaznik.getIdpolaznik());
        saveMessage(getText("polaznik.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idpolaznik != null) {
            polaznik = polaznikManager.get(idpolaznik);
        } else {
            polaznik = new Polaznik();
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

        boolean isNew = (polaznik.getIdpolaznik() == null);

        polaznikManager.save(polaznik);

        String key = (isNew) ? "polaznik.added" : "polaznik.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}