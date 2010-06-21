package edu.ftn.ais.webapp.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Preparable;

import edu.ftn.ais.model.Office;
import edu.ftn.ais.service.ClientManager;
import edu.ftn.ais.service.OfficeManager;

public class OfficeAction extends BaseAction implements Preparable {
    private OfficeManager officeManager;
    private List offices=null;
    private Office office;
    private Long  idoffice;

    //neso
    private ClientManager clientManager;
    private List clients = null;
    
    public void setOfficeManager(OfficeManager officeManager) {
        this.officeManager = officeManager;
    }

    //neso
    public void setClientManager(ClientManager clientManager){
    	this.clientManager=clientManager;
    }
    
    public List getOffices() {
        return offices;
    }
    
    //neso
    public List getClients(){
    	return clients;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
    	//neso
    	prepareLists();

    	
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String officeId = getRequest().getParameter("office.idoffice");
            if (officeId != null && !officeId.equals("")) {
                office = officeManager.get(new Long(officeId));
            }
        }
    }
    
    private void prepareLists(){
    	this.clients=clientManager.getAll();
    }

    public String list() {
        offices = officeManager.getAll();
        return SUCCESS;
    }

    public void setIdoffice(Long  idoffice) {
        this. idoffice =  idoffice;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String delete() {
        officeManager.remove(office.getIdoffice());
        saveMessage(getText("office.deleted"));

        return SUCCESS;
    }

    public String edit() throws Exception {
//    	System.out.println("************************************* sada nesto editujem!!!");
//        String rVremeOd = getRequest().getParameter("office.rvremeOd");
//        if (rVremeOd != null && !rVremeOd.equals("")) {
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            Date rVremeOdTime = sdf.parse(rVremeOd);
//            office.setRvremeOd(rVremeOdTime);
//            System.out.println("Vreme koje snimam je:"+rVremeOdTime);
//        }
        if (idoffice != null) {
            office = officeManager.get(idoffice);
        } else {
            office = new Office();
        }
        //neso
        return SUCCESS;
    }

    public String save() throws Exception {
//        System.out.println("****************************** sada nesto snimam!!!");
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (office.getIdoffice() == null);

        //neso
//        String rVremeOd = getRequest().getParameter("office.rvremeOd");
//        if (rVremeOd != null && !rVremeOd.equals("")) {
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            Date rVremeOdTime = sdf.parse(rVremeOd);
//            office.setRvremeOd(rVremeOdTime);
//            System.out.println("Vreme koje snimam je:"+rVremeOdTime);
//        }

        officeManager.save(office);

        String key = (isNew) ? "office.added" : "office.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}