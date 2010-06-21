package edu.ftn.ais.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="polaznik",catalog="pojo_test")
public class Polaznik extends BaseObject implements Serializable {
    private Long polaznikID;
    private String ime;
    private String prezime;
    private Date datumRodj;
    private String adresa;
    private String grad;
    private Long postBroj;
    private Date datumProjave;
    private String telefon;
    private String detalji;
//    private Set<Placanja> placanja= new HashSet<Placanja>(0);
//    private Set<Casovi> casovi= new HashSet<Casovi>(0);

    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdpolaznik() {
        return this.polaznikID;
    }
    
    public void setIdpolaznik(Long idpolaznik) {
        this.polaznikID = idpolaznik;
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
    @Temporal(TemporalType.DATE)
    @Column(name="DatumRodj", length=10)
    public Date getDatumRodj() {
        return this.datumRodj;
    }
    
    public void setDatumRodj(Date datumRodj) {
        this.datumRodj = datumRodj;
    }
    
    @Column(name="Adresa", length=50)
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    @Column(name="Grad", length=45)
    public String getGrad() {
        return this.grad;
    }
    
    public void setGrad(String grad) {
        this.grad = grad;
    }
    
    @Column(name="PostBroj")
    public Long getPostBroj() {
        return this.postBroj;
    }
    
    public void setPostBroj(Long postBroj) {
        this.postBroj = postBroj;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="DatumProjave", length=10)
    public Date getDatumProjave() {
        return this.datumProjave;
    }
    
    public void setDatumProjave(Date datumProjave) {
        this.datumProjave = datumProjave;
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
	 * @return the placanja
	 */
//	@OneToMany (cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="polaznikFK")
//	public Set<Placanja> getPlacanja() {
//		return placanja;
//	}

	/**
	 * @param placanja the placanja to set
	 */
//	public void setPlacanja(Set<Placanja> placanja) {
//		this.placanja = placanja;
//	}

	/**
	 * @return the casovi
	 */
//	@OneToMany (cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="polaznikFK")
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

        Polaznik pojo = (Polaznik) o;

        if (ime != null ? !ime.equals(pojo.ime) : pojo.ime != null) return false;
        if (prezime != null ? !prezime.equals(pojo.prezime) : pojo.prezime != null) return false;
        if (datumRodj != null ? !datumRodj.equals(pojo.datumRodj) : pojo.datumRodj != null) return false;
        if (adresa != null ? !adresa.equals(pojo.adresa) : pojo.adresa != null) return false;
        if (grad != null ? !grad.equals(pojo.grad) : pojo.grad != null) return false;
        if (postBroj != null ? !postBroj.equals(pojo.postBroj) : pojo.postBroj != null) return false;
        if (datumProjave != null ? !datumProjave.equals(pojo.datumProjave) : pojo.datumProjave != null) return false;
        if (telefon != null ? !telefon.equals(pojo.telefon) : pojo.telefon != null) return false;
        if (detalji != null ? !detalji.equals(pojo.detalji) : pojo.detalji != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (datumRodj != null ? datumRodj.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (grad != null ? grad.hashCode() : 0);
        result = 31 * result + (postBroj != null ? postBroj.hashCode() : 0);
        result = 31 * result + (datumProjave != null ? datumProjave.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (detalji != null ? detalji.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idpolaznik").append("='").append(getIdpolaznik()).append("', ");
        sb.append("ime").append("='").append(getIme()).append("', ");
        sb.append("prezime").append("='").append(getPrezime()).append("', ");
        sb.append("datumRodj").append("='").append(getDatumRodj()).append("', ");
        sb.append("adresa").append("='").append(getAdresa()).append("', ");
        sb.append("grad").append("='").append(getGrad()).append("', ");
        sb.append("postBroj").append("='").append(getPostBroj()).append("', ");
        sb.append("datumProjave").append("='").append(getDatumProjave()).append("', ");
        sb.append("telefon").append("='").append(getTelefon()).append("', ");
        sb.append("detalji").append("='").append(getDetalji()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
