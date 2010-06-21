package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.VoziloManager;
import edu.ftn.ais.model.Vozilo;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class VoziloAction extends BaseAction implements Preparable {
    private VoziloManager voziloManager;
    private List voziloes;
    private Vozilo vozilo;
    private Long  voziloID;

    public void setVoziloManager(VoziloManager voziloManager) {
        this.voziloManager = voziloManager;
    }

    public List getVoziloes() {
        return voziloes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String voziloId = getRequest().getParameter("vozilo.voziloID");
            if (voziloId != null && !voziloId.equals("")) {
                vozilo = voziloManager.get(new Long(voziloId));
            }
        }
    }

    public String list() {
        voziloes = voziloManager.getAll();
        return SUCCESS;
    }

    public void setVoziloID(Long  voziloID) {
        this. voziloID =  voziloID;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public String delete() {
        voziloManager.remove(vozilo.getVoziloID());
        saveMessage(getText("vozilo.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (voziloID != null) {
            vozilo = voziloManager.get(voziloID);
        } else {
            vozilo = new Vozilo();
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

        boolean isNew = (vozilo.getVoziloID() == null);

        voziloManager.save(vozilo);

        String key = (isNew) ? "vozilo.added" : "vozilo.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}