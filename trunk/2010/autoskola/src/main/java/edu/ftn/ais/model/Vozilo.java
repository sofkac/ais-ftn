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
@Table(name="vozilo",catalog="pojo_test")
public class Vozilo extends BaseObject implements Serializable {
    private Long voziloID;
    private String regBroj;
    private String marka;
    private String model;
    private Long godiste;
    private String detalji;
//    private Set<Casovi> casovi= new HashSet<Casovi>(0);


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getVoziloID() {
        return this.voziloID;
    }
    
    public void setVoziloID(Long voziloID) {
        this.voziloID = voziloID;
    }
    
    @Column(name="RegBroj", nullable=false, length=10)
    public String getRegBroj() {
        return this.regBroj;
    }
    
    public void setRegBroj(String regBroj) {
        this.regBroj = regBroj;
    }
    
    @Column(name="Marka", nullable=false, length=45)
    public String getMarka() {
        return this.marka;
    }
    
    public void setMarka(String marka) {
        this.marka = marka;
    }
    
    @Column(name="Model", nullable=false, length=45)
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    @Column(name="Godiste")
    public Long getGodiste() {
        return this.godiste;
    }
    
    public void setGodiste(Long godiste) {
        this.godiste = godiste;
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
//	@OneToMany (cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="voziloFK")
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

        Vozilo pojo = (Vozilo) o;

        if (regBroj != null ? !regBroj.equals(pojo.regBroj) : pojo.regBroj != null) return false;
        if (marka != null ? !marka.equals(pojo.marka) : pojo.marka != null) return false;
        if (model != null ? !model.equals(pojo.model) : pojo.model != null) return false;
        if (godiste != null ? !godiste.equals(pojo.godiste) : pojo.godiste != null) return false;
        if (detalji != null ? !detalji.equals(pojo.detalji) : pojo.detalji != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (regBroj != null ? regBroj.hashCode() : 0);
        result = 31 * result + (marka != null ? marka.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (godiste != null ? godiste.hashCode() : 0);
        result = 31 * result + (detalji != null ? detalji.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idvozilo").append("='").append(getVoziloID()).append("', ");
        sb.append("regBroj").append("='").append(getRegBroj()).append("', ");
        sb.append("marka").append("='").append(getMarka()).append("', ");
        sb.append("model").append("='").append(getModel()).append("', ");
        sb.append("godiste").append("='").append(getGodiste()).append("', ");
        sb.append("detalji").append("='").append(getDetalji()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
