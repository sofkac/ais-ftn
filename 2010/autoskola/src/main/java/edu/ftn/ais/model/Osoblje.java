package edu.ftn.ais.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="osoblje",catalog="pojo_test")
public class Osoblje extends BaseObject implements Serializable {
    private Long osobljeID;
    private String ime;
    private String prezime;
    private Long vrsta;
    private String telefon;
    private String detalji;
//    private Set<Casovi> casovi= new HashSet<Casovi>(0);


    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getOsobljeID() {
        return this.osobljeID;
    }
    
    public void setOsobljeID(Long osobljeID) {
        this.osobljeID = osobljeID;
    }
    
    @Column(name="Ime", nullable=false, length=20)
    public String getIme() {
        return this.ime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }
    
    @Column(name="Prezime", nullable=false, length=25)
    public String getPrezime() {
        return this.prezime;
    }
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    @Column(name="Vrsta", nullable=false)
    public Long getVrsta() {
        return this.vrsta;
    }
    
    public void setVrsta(Long vrsta) {
        this.vrsta = vrsta;
    }
    
    @Column(name="Telefon", length=15)
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    @Column(name="Detalji", length=200)
    public String getDetalji() {
        return this.detalji;
    }
    
    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }

    /**
	 * @return the casovi
	 */
//	@OneToMany (cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="osobljeFK")
//	public Set<Casovi> getCasovi() {
//		return casovi;
//	}

	/**
	 * @param casovi the casovi to set
	 */
//	public void setCasovi(Set<Casovi> casovi) {
//		this.casovi = casovi;
//	}

	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Osoblje pojo = (Osoblje) o;

        if (ime != null ? !ime.equals(pojo.ime) : pojo.ime != null) return false;
        if (prezime != null ? !prezime.equals(pojo.prezime) : pojo.prezime != null) return false;
        if (vrsta != null ? !vrsta.equals(pojo.vrsta) : pojo.vrsta != null) return false;
        if (telefon != null ? !telefon.equals(pojo.telefon) : pojo.telefon != null) return false;
        if (detalji != null ? !detalji.equals(pojo.detalji) : pojo.detalji != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (vrsta != null ? vrsta.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (detalji != null ? detalji.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idosoblje").append("='").append(getOsobljeID()).append("', ");
        sb.append("ime").append("='").append(getIme()).append("', ");
        sb.append("prezime").append("='").append(getPrezime()).append("', ");
        sb.append("vrsta").append("='").append(getVrsta()).append("', ");
        sb.append("telefon").append("='").append(getTelefon()).append("', ");
        sb.append("detalji").append("='").append(getDetalji()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
