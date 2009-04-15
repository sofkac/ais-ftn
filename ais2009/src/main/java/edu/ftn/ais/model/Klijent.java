package edu.ftn.ais.model;

import edu.ftn.ais.model.BaseObject;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name="klijent",catalog="ais2009")
public class Klijent extends BaseObject implements Serializable {
    private Long idk;
    private String naziv;
    private String adresa;
    private String mesto;
    private String telefon;
    private Set<Faktura> fakturas = new HashSet<Faktura>(0);

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdk() {
        return this.idk;
    }
    
    public void setIdk(Long idk) {
        this.idk = idk;
    }
    
    @Column(name="Naziv", nullable=false, length=45)
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    @Column(name="Adresa", nullable=false, length=45)
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    @Column(name="Mesto", nullable=false, length=25)
    public String getMesto() {
        return this.mesto;
    }
    
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
    
    @Column(name="Telefon", length=15)
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="klijent")
    public Set<Faktura> getFakturas() {
        return this.fakturas;
    }
    
    public void setFakturas(Set<Faktura> fakturas) {
        this.fakturas = fakturas;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klijent pojo = (Klijent) o;

        if (naziv != null ? !naziv.equals(pojo.naziv) : pojo.naziv != null) return false;
        if (adresa != null ? !adresa.equals(pojo.adresa) : pojo.adresa != null) return false;
        if (mesto != null ? !mesto.equals(pojo.mesto) : pojo.mesto != null) return false;
        if (telefon != null ? !telefon.equals(pojo.telefon) : pojo.telefon != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (mesto != null ? mesto.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idk").append("='").append(getIdk()).append("', ");
        sb.append("naziv").append("='").append(getNaziv()).append("', ");
        sb.append("adresa").append("='").append(getAdresa()).append("', ");
        sb.append("mesto").append("='").append(getMesto()).append("', ");
        sb.append("telefon").append("='").append(getTelefon()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
