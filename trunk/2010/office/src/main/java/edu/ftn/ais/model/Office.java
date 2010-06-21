package edu.ftn.ais.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="office",catalog="office")
public class Office extends BaseObject implements Serializable {
    private Long idoffice;
    private Client client;
    private String adresa;
    private String grad;
//    private Date rvremeOd;
//    private Date rvremeDo;

    @Id @GeneratedValue(strategy=GenerationType.AUTO)    
    public Long getIdoffice() {
        return this.idoffice;
    }
    
    public void setIdoffice(Long idoffice) {
        this.idoffice = idoffice;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="client_IDclient", nullable=false)
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    @Column(name="Adresa", nullable=false, length=45)
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    @Column(name="Grad", nullable=false, length=45)
    public String getGrad() {
        return this.grad;
    }
    
    public void setGrad(String grad) {
        this.grad = grad;
    }
//    @Temporal(TemporalType.TIME)
//    @Column(name="RVremeOd", length=8)
//    public Date getRvremeOd() {
//        return this.rvremeOd;
//    }
    
//    public void setRvremeOd(Date rvremeOd) {
//        this.rvremeOd = rvremeOd;
//    }
//    @Temporal(TemporalType.DATE)
//    @Column(name="RVremeDo", length=0)
//    public Date getRvremeDo() {
//        return this.rvremeDo;
//    }
    
//    public void setRvremeDo(Date rvremeDo) {
//        this.rvremeDo = rvremeDo;
//    }
    

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office pojo = (Office) o;

        if (client != null ? !client.equals(pojo.client) : pojo.client != null) return false;
        if (adresa != null ? !adresa.equals(pojo.adresa) : pojo.adresa != null) return false;
        if (grad != null ? !grad.equals(pojo.grad) : pojo.grad != null) return false;
//        if (rvremeOd != null ? !rvremeOd.equals(pojo.rvremeOd) : pojo.rvremeOd != null) return false;
//        if (rvremeDo != null ? !rvremeDo.equals(pojo.rvremeDo) : pojo.rvremeDo != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (client != null ? client.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (grad != null ? grad.hashCode() : 0);
//        result = 31 * result + (rvremeOd != null ? rvremeOd.hashCode() : 0);
//        result = 31 * result + (rvremeDo != null ? rvremeDo.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idoffice").append("='").append(getIdoffice()).append("', ");
        sb.append("client").append("='").append(getClient()).append("', ");
        sb.append("adresa").append("='").append(getAdresa()).append("', ");
        sb.append("grad").append("='").append(getGrad()).append("', ");
//        sb.append("rvremeOd").append("='").append(getRvremeOd()).append("', ");
//        sb.append("rvremeDo").append("='").append(getRvremeDo()).append("', ");
        sb.append("]");
      
        return sb.toString();
    }

}
