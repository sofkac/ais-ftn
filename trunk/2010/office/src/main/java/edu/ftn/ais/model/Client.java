package edu.ftn.ais.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="client",catalog="office")
public class Client extends BaseObject implements Serializable {
    private Long idclient;
    private String naziv;
    private Date datumOsnivanja;
    private String opis;
//    private Set<Office> offices = new HashSet<Office>(0);

    @Id @GeneratedValue(strategy=GenerationType.AUTO)    
    public Long getIdclient() {
        return this.idclient;
    }
    
    public void setIdclient(Long idclient) {
        this.idclient = idclient;
    }
    
    @Column(name="Naziv", nullable=false, length=25)
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="DatumOsnivanja", nullable=false, length=0)
    public Date getDatumOsnivanja() {
        return this.datumOsnivanja;
    }
    
    public void setDatumOsnivanja(Date datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }
    
    @Column(name="Opis", length=250)
    public String getOpis() {
        return this.opis;
    }
    
    public void setOpis(String opis) {
        this.opis = opis;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="client")
//    public Set<Office> getOffices() {
//        return this.offices;
//    }
    
//    public void setOffices(Set<Office> offices) {
//        this.offices = offices;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client pojo = (Client) o;

        if (naziv != null ? !naziv.equals(pojo.naziv) : pojo.naziv != null) return false;
        if (datumOsnivanja != null ? !datumOsnivanja.equals(pojo.datumOsnivanja) : pojo.datumOsnivanja != null) return false;
        if (opis != null ? !opis.equals(pojo.opis) : pojo.opis != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (datumOsnivanja != null ? datumOsnivanja.hashCode() : 0);
        result = 31 * result + (opis != null ? opis.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idclient").append("='").append(getIdclient()).append("', ");
        sb.append("naziv").append("='").append(getNaziv()).append("', ");
        sb.append("datumOsnivanja").append("='").append(getDatumOsnivanja()).append("', ");
        sb.append("opis").append("='").append(getOpis()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
