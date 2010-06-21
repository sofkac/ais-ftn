package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.OsobljeManager;
import edu.ftn.ais.model.Osoblje;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class OsobljeAction extends BaseAction implements Preparable {
    private OsobljeManager osobljeManager;
    private List osobljes;
    private Osoblje osoblje;
    private Long  osobljeID;

    public void setOsobljeManager(OsobljeManager osobljeManager) {
        this.osobljeManager = osobljeManager;
    }

    public List getOsobljes() {
        return osobljes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String osobljeId = getRequest().getParameter("osoblje.osobljeID");
            if (osobljeId != null && !osobljeId.equals("")) {
                osoblje = osobljeManager.get(new Long(osobljeId));
            }
        }
    }

    public String list() {
        osobljes = osobljeManager.getAll();
        return SUCCESS;
    }

    public void setOsobljeID(Long  osobljeID) {
        this. osobljeID =  osobljeID;
    }

    public Osoblje getOsoblje() {
        return osoblje;
    }

    public void setOsoblje(Osoblje osoblje) {
        this.osoblje = osoblje;
    }

    public String delete() {
        osobljeManager.remove(osoblje.getOsobljeID());
        saveMessage(getText("osoblje.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (osobljeID != null) {
            osoblje = osobljeManager.get(osobljeID);
        } else {
            osoblje = new Osoblje();
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

        boolean isNew = (osoblje.getOsobljeID() == null);

        osobljeManager.save(osoblje);

        String key = (isNew) ? "osoblje.added" : "osoblje.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}