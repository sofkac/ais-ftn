package edu.ftn.ais.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name="casovi",catalog="pojo_test")
public class Casovi extends BaseObject implements Serializable {
    private Long casID;
    private Date datumCasa;
    private String vremeOd;
    private String vremeDo;
    private String detalji;
    private Long vrsta;
    private Long status;
    private Polaznik polaznikFK;
    private Vozilo voziloFK;
    private Osoblje osobljeFK;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdCas() {
        return this.casID;
    }
    
    public void setIdCas(Long idCas) {
        this.casID = idCas;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="datumCasa", nullable=false, length=10)
    public Date getDatumCasa() {
        return this.datumCasa;
    }
    
    public void setDatumCasa(Date datumCasa) {
        this.datumCasa = datumCasa;
    }
    @Column(name="vremeOd", nullable=false, length=8)
    public String getVremeOd() {
        return this.vremeOd;
    }
    
    public void setVremeOd(String vremeOd) {
        this.vremeOd = vremeOd;
    }
    @Column(name="vremeDo", nullable=false, length=8)
    public String getVremeDo() {
        return this.vremeDo;
    }
    
    public void setVremeDo(String vremeDo) {
        this.vremeDo = vremeDo;
    }
    
    @Column(name="Detalji", length=200)
    public String getDetalji() {
        return this.detalji;
    }
    
    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }
    
    @Column(name="Vrsta", nullable=false)
    public Long getVrsta() {
        return this.vrsta;
    }
    
    public void setVrsta(Long vrsta) {
        this.vrsta = vrsta;
    }
    
    @Column(name="Status", nullable=false)
    public Long getStatus() {
        return this.status;
    }
    
    public void setStatus(Long status) {
        this.status = status;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="polaznikFK", nullable=false)
    public Polaznik getPolaznikFK() {
        return this.polaznikFK;
    }
    
    public void setPolaznikFK(Polaznik polaznikFK) {
        this.polaznikFK = polaznikFK;
    }
    
//    @Column(name="voziloFK", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="voziloFK", nullable=false)
    public Vozilo getVoziloFK() {
        return this.voziloFK;
    }
    
    public void setVoziloFK(Vozilo voziloFK) {
        this.voziloFK = voziloFK;
    }
    
//    @Column(name="osobljeFK", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="osobljeFK", nullable=false)
    public Osoblje getOsobljeFK() {
        return this.osobljeFK;
    }
    
    public void setOsobljeFK(Osoblje osobljeFK) {
        this.osobljeFK = osobljeFK;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casovi pojo = (Casovi) o;

        if (datumCasa != null ? !datumCasa.equals(pojo.datumCasa) : pojo.datumCasa != null) return false;
        if (vremeOd != null ? !vremeOd.equals(pojo.vremeOd) : pojo.vremeOd != null) return false;
        if (vremeDo != null ? !vremeDo.equals(pojo.vremeDo) : pojo.vremeDo != null) return false;
        if (detalji != null ? !detalji.equals(pojo.detalji) : pojo.detalji != null) return false;
        if (vrsta != null ? !vrsta.equals(pojo.vrsta) : pojo.vrsta != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;
        if (polaznikFK != null ? !polaznikFK.equals(pojo.polaznikFK) : pojo.polaznikFK != null) return false;
        if (voziloFK != null ? !voziloFK.equals(pojo.voziloFK) : pojo.voziloFK != null) return false;
        if (osobljeFK != null ? !osobljeFK.equals(pojo.osobljeFK) : pojo.osobljeFK != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (datumCasa != null ? datumCasa.hashCode() : 0);
        result = 31 * result + (vremeOd != null ? vremeOd.hashCode() : 0);
        result = 31 * result + (vremeDo != null ? vremeDo.hashCode() : 0);
        result = 31 * result + (detalji != null ? detalji.hashCode() : 0);
        result = 31 * result + (vrsta != null ? vrsta.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (polaznikFK != null ? polaznikFK.hashCode() : 0);
        result = 31 * result + (voziloFK != null ? voziloFK.hashCode() : 0);
        result = 31 * result + (osobljeFK != null ? osobljeFK.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idCas").append("='").append(getIdCas()).append("', ");
        sb.append("datumCasa").append("='").append(getDatumCasa()).append("', ");
        sb.append("vremeOd").append("='").append(getVremeOd()).append("', ");
        sb.append("vremeDo").append("='").append(getVremeDo()).append("', ");
        sb.append("detalji").append("='").append(getDetalji()).append("', ");
        sb.append("vrsta").append("='").append(getVrsta()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("', ");
        sb.append("fkPolaznikIdpolaznik").append("='").append(getPolaznikFK()).append("', ");
        sb.append("fkVoziloIdvozilo").append("='").append(getVoziloFK()).append("', ");
        sb.append("fkOsobljeIdosoblje").append("='").append(getOsobljeFK()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
