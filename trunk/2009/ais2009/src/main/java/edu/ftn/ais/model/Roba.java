package edu.ftn.ais.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roba",catalog="ais2009")
public class Roba extends BaseObject implements Serializable {
    private Long idr;
    private String naziv;
    private Long kolicina;
    private String jm;
    private String napomena;
//    private Set<Stavke> stavkes = new HashSet<Stavke>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdr() {
        return this.idr;
    }
    
    public void setIdr(Long idr) {
        this.idr = idr;
    }
    
    @Column(name="Naziv", nullable=false, length=50)
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    @Column(name="Kolicina", nullable=false)
    public Long getKolicina() {
        return this.kolicina;
    }
    
    public void setKolicina(Long kolicina) {
        this.kolicina = kolicina;
    }
    
    @Column(name="JM", nullable=false, length=10)
    public String getJm() {
        return this.jm;
    }
    
    public void setJm(String jm) {
        this.jm = jm;
    }
    
    @Column(name="Napomena", length=100)
    public String getNapomena() {
        return this.napomena;
    }
    
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="roba")
//    public Set<Stavke> getStavkes() {
//        return this.stavkes;
//    }
    
//    public void setStavkes(Set<Stavke> stavkes) {
//        this.stavkes = stavkes;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roba pojo = (Roba) o;

        if (naziv != null ? !naziv.equals(pojo.naziv) : pojo.naziv != null) return false;
        if (kolicina != null ? !kolicina.equals(pojo.kolicina) : pojo.kolicina != null) return false;
        if (jm != null ? !jm.equals(pojo.jm) : pojo.jm != null) return false;
        if (napomena != null ? !napomena.equals(pojo.napomena) : pojo.napomena != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (kolicina != null ? kolicina.hashCode() : 0);
        result = 31 * result + (jm != null ? jm.hashCode() : 0);
        result = 31 * result + (napomena != null ? napomena.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idr").append("='").append(getIdr()).append("', ");
        sb.append("naziv").append("='").append(getNaziv()).append("', ");
        sb.append("kolicina").append("='").append(getKolicina()).append("', ");
        sb.append("jm").append("='").append(getJm()).append("', ");
        sb.append("napomena").append("='").append(getNapomena()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
