package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import ftn.edu.ais.service.ZanimanjeManager;
import ftn.edu.ais.model.Zanimanje;
import ftn.edu.ais.webapp.action.BaseAction;

import java.util.List;

public class ZanimanjeAction extends BaseAction implements Preparable {
    private ZanimanjeManager zanimanjeManager;
    private List zanimanjes;
    private Zanimanje zanimanje;
    private Long  idzan;

    public void setZanimanjeManager(ZanimanjeManager zanimanjeManager) {
        this.zanimanjeManager = zanimanjeManager;
    }

    public List getZanimanjes() {
        return zanimanjes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String zanimanjeId = getRequest().getParameter("zanimanje.idzan");
            if (zanimanjeId != null && !zanimanjeId.equals("")) {
                zanimanje = zanimanjeManager.get(new Long(zanimanjeId));
            }
        }
    }

    public String list() {
        zanimanjes = zanimanjeManager.getAll();
        return SUCCESS;
    }

    public void setIdzan(Long  idzan) {
        this. idzan =  idzan;
    }

    public Zanimanje getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(Zanimanje zanimanje) {
        this.zanimanje = zanimanje;
    }

    public String delete() {
        zanimanjeManager.remove(zanimanje.getIdzan());
        saveMessage(getText("zanimanje.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idzan != null) {
            zanimanje = zanimanjeManager.get(idzan);
        } else {
            zanimanje = new Zanimanje();
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

        boolean isNew = (zanimanje.getIdzan() == null);

        zanimanjeManager.save(zanimanje);

        String key = (isNew) ? "zanimanje.added" : "zanimanje.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}