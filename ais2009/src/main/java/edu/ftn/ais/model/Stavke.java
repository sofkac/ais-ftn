package edu.ftn.ais.model;

import edu.ftn.ais.model.BaseObject;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name="stavke",catalog="ais2009")
public class Stavke extends BaseObject implements Serializable {
    private Long ids;
    private Roba roba;
    private Faktura faktura;
    private BigDecimal kolicina;
    private String napomena;

    @Id @GeneratedValue(strategy=IDENTITY) @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIds() {
        return this.ids;
    }
    
    public void setIds(Long ids) {
        this.ids = ids;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_R", nullable=false)
    public Roba getRoba() {
        return this.roba;
    }
    
    public void setRoba(Roba roba) {
        this.roba = roba;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_F", nullable=false)
    public Faktura getFaktura() {
        return this.faktura;
    }
    
    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
    
    @Column(name="Kolicina", nullable=false, precision=12)
    public BigDecimal getKolicina() {
        return this.kolicina;
    }
    
    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }
    
    @Column(name="Napomena", length=15)
    public String getNapomena() {
        return this.napomena;
    }
    
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stavke pojo = (Stavke) o;

        if (roba != null ? !roba.equals(pojo.roba) : pojo.roba != null) return false;
        if (faktura != null ? !faktura.equals(pojo.faktura) : pojo.faktura != null) return false;
        if (kolicina != null ? !kolicina.equals(pojo.kolicina) : pojo.kolicina != null) return false;
        if (napomena != null ? !napomena.equals(pojo.napomena) : pojo.napomena != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (roba != null ? roba.hashCode() : 0);
        result = 31 * result + (faktura != null ? faktura.hashCode() : 0);
        result = 31 * result + (kolicina != null ? kolicina.hashCode() : 0);
        result = 31 * result + (napomena != null ? napomena.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("ids").append("='").append(getIds()).append("', ");
        sb.append("roba").append("='").append(getRoba()).append("', ");
        sb.append("faktura").append("='").append(getFaktura()).append("', ");
        sb.append("kolicina").append("='").append(getKolicina()).append("', ");
        sb.append("napomena").append("='").append(getNapomena()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
