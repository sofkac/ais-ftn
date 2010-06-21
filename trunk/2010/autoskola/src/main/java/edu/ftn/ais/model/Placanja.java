package edu.ftn.ais.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="placanja",catalog="pojo_test")
public class Placanja extends BaseObject implements Serializable {
    private Long placanjeID;
    private Date date;
    private Polaznik polaznikFK;
    private BigDecimal iznos;
    private String detalji;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdplacanje() {
        return this.placanjeID;
    }
    
    public void setIdplacanje(Long idplacanje) {
        this.placanjeID = idplacanje;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="Date", nullable=false, length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="polaznikFK", nullable=false)
    public Polaznik getPolaznikFK() {
        return this.polaznikFK;
    }
    
    public void setPolaznikFK(Polaznik polaznikFK) {
        this.polaznikFK = polaznikFK;
    }
    
    @Column(name="Iznos", nullable=false, precision=7)
    public BigDecimal getIznos() {
        return this.iznos;
    }
    
    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }
    
    @Column(name="Detalji", length=200)
    public String getDetalji() {
        return this.detalji;
    }
    
    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Placanja pojo = (Placanja) o;

        if (date != null ? !date.equals(pojo.date) : pojo.date != null) return false;
        if (polaznikFK != null ? !polaznikFK.equals(pojo.polaznikFK) : pojo.polaznikFK != null) return false;
        if (iznos != null ? !iznos.equals(pojo.iznos) : pojo.iznos != null) return false;
        if (detalji != null ? !detalji.equals(pojo.detalji) : pojo.detalji != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (date != null ? date.hashCode() : 0);
        result = 31 * result + (polaznikFK != null ? polaznikFK.hashCode() : 0);
        result = 31 * result + (iznos != null ? iznos.hashCode() : 0);
        result = 31 * result + (detalji != null ? detalji.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idplacanje").append("='").append(getIdplacanje()).append("', ");
        sb.append("date").append("='").append(getDate()).append("', ");
		sb.append(polaznikFK.toString());
        sb.append("fkIdpolaznik").append("='").append(getPolaznikFK()).append("', ");
        sb.append("iznos").append("='").append(getIznos()).append("', ");
        sb.append("detalji").append("='").append(getDetalji()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
