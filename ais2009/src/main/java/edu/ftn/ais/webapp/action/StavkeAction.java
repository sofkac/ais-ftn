package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.StavkeManager;
import edu.ftn.ais.model.Stavke;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class StavkeAction extends BaseAction implements Preparable {
    private StavkeManager stavkeManager;
    private List stavkes;
    private Stavke stavke;
    private Long  ids;

    public void setStavkeManager(StavkeManager stavkeManager) {
        this.stavkeManager = stavkeManager;
    }

    public List getStavkes() {
        return stavkes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String stavkeId = getRequest().getParameter("stavke.ids");
            if (stavkeId != null && !stavkeId.equals("")) {
                stavke = stavkeManager.get(new Long(stavkeId));
            }
        }
    }

    public String list() {
        stavkes = stavkeManager.getAll();
        return SUCCESS;
    }

    public void setIds(Long  ids) {
        this. ids =  ids;
    }

    public Stavke getStavke() {
        return stavke;
    }

    public void setStavke(Stavke stavke) {
        this.stavke = stavke;
    }

    public String delete() {
        stavkeManager.remove(stavke.getIds());
        saveMessage(getText("stavke.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (ids != null) {
            stavke = stavkeManager.get(ids);
        } else {
            stavke = new Stavke();
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

        boolean isNew = (stavke.getIds() == null);

        stavkeManager.save(stavke);

        String key = (isNew) ? "stavke.added" : "stavke.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}