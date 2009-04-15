package edu.ftn.ais.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="faktura",catalog="ais2009")
public class Faktura extends BaseObject implements Serializable {
    private Long idf;
    private Klijent klijent;
    private Date datum;
    private BigDecimal iznos;
    private String napomena;
//    private Set<Stavke> stavkes = new HashSet<Stavke>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdf() {
        return this.idf;
    }
    
    public void setIdf(Long idf) {
        this.idf = idf;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FK_K", nullable=false)
    public Klijent getKlijent() {
        return this.klijent;
    }
    
    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="Datum", nullable=false, length=0)
    public Date getDatum() {
        return this.datum;
    }
    
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    @Column(name="Iznos", precision=12)
    public BigDecimal getIznos() {
        return this.iznos;
    }
    
    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }
    
    @Column(name="Napomena", length=200)
    public String getNapomena() {
        return this.napomena;
    }
    
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="faktura")
//    public Set<Stavke> getStavkes() {
//        return this.stavkes;
//    }
    
//    public void setStavkes(Set<Stavke> stavkes) {
//        this.stavkes = stavkes;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faktura pojo = (Faktura) o;

        if (klijent != null ? !klijent.equals(pojo.klijent) : pojo.klijent != null) return false;
        if (datum != null ? !datum.equals(pojo.datum) : pojo.datum != null) return false;
        if (iznos != null ? !iznos.equals(pojo.iznos) : pojo.iznos != null) return false;
        if (napomena != null ? !napomena.equals(pojo.napomena) : pojo.napomena != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (klijent != null ? klijent.hashCode() : 0);
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + (iznos != null ? iznos.hashCode() : 0);
        result = 31 * result + (napomena != null ? napomena.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idf").append("='").append(getIdf()).append("', ");
        sb.append("klijent").append("='").append(getKlijent()).append("', ");
        sb.append("datum").append("='").append(getDatum()).append("', ");
        sb.append("iznos").append("='").append(getIznos()).append("', ");
        sb.append("napomena").append("='").append(getNapomena()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
