package edu.ftn.ais.webapp.action;

import com.opensymphony.xwork2.Preparable;
import edu.ftn.ais.service.PlacanjaManager;
import edu.ftn.ais.service.PolaznikManager;
import edu.ftn.ais.model.Placanja;
import edu.ftn.ais.webapp.action.BaseAction;

import java.util.List;

public class PlacanjaAction extends BaseAction implements Preparable {
    private PlacanjaManager placanjaManager;
    private List placanjas=null;
    private Placanja placanja;
    private Long  idplacanje;
    
    //added by neso
    private PolaznikManager polaznikManager;
    private List polazniks=null;

    //added by neso
    public void setPolaznikManager(PolaznikManager polaznikManager){
    	this.polaznikManager = polaznikManager;
    }
    
    public void setPlacanjaManager(PlacanjaManager placanjaManager) {
        this.placanjaManager = placanjaManager;
    }

    //added by neso
    public List getPolazniks() {
        return polazniks;
    }
    
    
    public List getPlacanjas() {
        return placanjas;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
    	//added by neso
    	//this.polazniks = polaznikManager.getAll();
    	prepareLists();
    	
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String placanjaId = getRequest().getParameter("placanja.idplacanje");
            if (placanjaId != null && !placanjaId.equals("")) {
                placanja = placanjaManager.get(new Long(placanjaId));
            }
        }
    }

    //added by neso
    private void prepareLists() {
        this.polazniks = polaznikManager.getAll();
	}
    
    public String list() {
        placanjas = placanjaManager.getAll();
        return SUCCESS;
    }

    public void setIdplacanje(Long  idplacanje) {
        this. idplacanje =  idplacanje;
    }

    public Placanja getPlacanja() {
        return placanja;
    }

    public void setPlacanja(Placanja placanja) {
        this.placanja = placanja;
    }

    public String delete() {
        placanjaManager.remove(placanja.getIdplacanje());
        saveMessage(getText("placanja.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (idplacanje != null) {
            placanja = placanjaManager.get(idplacanje);
        } else {
            placanja = new Placanja();
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

        boolean isNew = (placanja.getIdplacanje() == null);

        placanjaManager.save(placanja);

        String key = (isNew) ? "placanja.added" : "placanja.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}