package edu.ftn.ais.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.Preparable;

import edu.ftn.ais.model.Stavke;
import edu.ftn.ais.service.FakturaManager;
import edu.ftn.ais.service.KlijentManager;
import edu.ftn.ais.service.RobaManager;
import edu.ftn.ais.service.StavkeManager;

public class StavkeAction extends BaseAction implements Preparable {
    private StavkeManager stavkeManager;
    private RobaManager robaManager;
    private FakturaManager fakturaManager;
    private KlijentManager klijentManager;
    
    private List stavkes = null;
    private List robas = null;
    private List fakturas = null;
    
    private Stavke stavke;
    private Long  ids;

    public void setStavkeManager(StavkeManager stavkeManager) {
        this.stavkeManager = stavkeManager;
    }

    //added by neso
    public void setRobaManager(RobaManager robaManager) {
        this.robaManager = robaManager;
    }

    //added by neso
    public void setFakturaManager(FakturaManager fakturaManager) {
        this.fakturaManager = fakturaManager;
    }

    //added by neso
    public void setKlijentManager(KlijentManager klijentManager) {
        this.klijentManager = klijentManager;
    }

    public List getStavkes() {
        return stavkes;
    }

    //added by neso
    public List getFakturas() {
        return fakturas;
    }

    //added by neso
    public List getRobas() {
        return robas;
    }
    
    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
    	//added by neso
    	prepareLists();		
        //end
    	
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String stavkeId = getRequest().getParameter("stavke.ids");
            if (stavkeId != null && !stavkeId.equals("")) {
                stavke = stavkeManager.get(new Long(stavkeId));
            }
        }
    }

	//added by neso
    private void prepareLists() {   	
        this.robas = robaManager.getAll();
        this.fakturas = fakturaManager.getAll();
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