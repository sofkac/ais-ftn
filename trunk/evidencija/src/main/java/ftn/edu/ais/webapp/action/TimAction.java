package ftn.edu.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import ftn.edu.ais.service.TimManager;
import ftn.edu.ais.model.Tim;
import ftn.edu.ais.webapp.action.BaseAction;

import java.util.List;

public class TimAction extends BaseAction implements Preparable {
    private TimManager timManager;
    private List tims;
    private Tim tim;
    private Long  idt;

    public void setTimManager(TimManager timManager) {
        this.timManager = timManager;
    }

    public List getTims() {
        return tims;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String timId = getRequest().getParameter("tim.idt");
            if (timId != null && !timId.equals("")) {
                tim = timManager.get(new Long(timId));
            }
        }
    }

    public String list() {
        tims = timManager.getAll();
        return SUCCESS;
    }

    public void setIdt(Long  idt) {
        this. idt =  idt;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public String delete() {
        timManager.remove(tim.getIdt());
        saveMessage(getText("tim.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idt != null) {
            tim = timManager.get(idt);
        } else {
            tim = new Tim();
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

        boolean isNew = (tim.getIdt() == null);

        timManager.save(tim);

        String key = (isNew) ? "tim.added" : "tim.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}