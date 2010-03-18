package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.RobaManager;
import edu.ftn.ais.model.Roba;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class RobaAction extends BaseAction implements Preparable {
    private RobaManager robaManager;
    private List robas;
    private Roba roba;
    private Long  idr;

    public void setRobaManager(RobaManager robaManager) {
        this.robaManager = robaManager;
    }

    public List getRobas() {
        return robas;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String robaId = getRequest().getParameter("roba.idr");
            if (robaId != null && !robaId.equals("")) {
                roba = robaManager.get(new Long(robaId));
            }
        }
    }

    public String list() {
        robas = robaManager.getAll();
        return SUCCESS;
    }

    public void setIdr(Long  idr) {
        this. idr =  idr;
    }

    public Roba getRoba() {
        return roba;
    }

    public void setRoba(Roba roba) {
        this.roba = roba;
    }

    public String delete() {
        robaManager.remove(roba.getIdr());
        saveMessage(getText("roba.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idr != null) {
            roba = robaManager.get(idr);
        } else {
            roba = new Roba();
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

        boolean isNew = (roba.getIdr() == null);

        robaManager.save(roba);

        String key = (isNew) ? "roba.added" : "roba.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}