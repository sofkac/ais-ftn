package ftn.edu.ais.model;

//import ftn.edu.ais.model.BaseObject;

//import java.util.HashSet;
//import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
//@Table(name="zaposleni",catalog="evidencija", uniqueConstraints = @UniqueConstraint(columnNames="jmbz") )
@Table(name="zaposleni",catalog="evidencija" )
public class Zaposleni extends BaseObject implements Serializable {
    private Long idz;
    private Zanimanje zanimanje;
    private String jmbz;
    private String imez;
    private String przz;
    private String adrz;
    private String gradz;
    private String zipz;
    private String telz;
    private String mailz;
    //private Set<Angazovan> angazovans = new HashSet<Angazovan>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdz() {
        return this.idz;
    }
    
    public void setIdz(Long idz) {
        this.idz = idz;
    }
@ManyToOne(fetch=FetchType.EAGER)//dodala umesto LAZY
    @JoinColumn(name="idzan")
    public Zanimanje getZanimanje() {
        return this.zanimanje;
    }
    
    public void setZanimanje(Zanimanje zanimanje) {
        this.zanimanje = zanimanje;
    }
    
    @Column(name="jmbz", unique=true, nullable=false, length=13)
    public String getJmbz() {
        return this.jmbz;
    }
    
    public void setJmbz(String jmbz) {
        this.jmbz = jmbz;
    }
    
    @Column(name="imez", nullable=false, length=20)
    public String getImez() {
        return this.imez;
    }
    
    public void setImez(String imez) {
        this.imez = imez;
    }
    
    @Column(name="przz", nullable=false, length=20)
    public String getPrzz() {
        return this.przz;
    }
    
    public void setPrzz(String przz) {
        this.przz = przz;
    }
    
    @Column(name="adrz", nullable=false, length=50)
    public String getAdrz() {
        return this.adrz;
    }
    
    public void setAdrz(String adrz) {
        this.adrz = adrz;
    }
    
    @Column(name="gradz", nullable=false, length=20)
    public String getGradz() {
        return this.gradz;
    }
    
    public void setGradz(String gradz) {
        this.gradz = gradz;
    }
    
    @Column(name="zipz", nullable=false, length=10)
    public String getZipz() {
        return this.zipz;
    }
    
    public void setZipz(String zipz) {
        this.zipz = zipz;
    }
    
    @Column(name="telz", nullable=false, length=15)
    public String getTelz() {
        return this.telz;
    }
    
    public void setTelz(String telz) {
        this.telz = telz;
    }
    
    @Column(name="mailz", nullable=false, length=50)
    public String getMailz() {
        return this.mailz;
    }
    
    public void setMailz(String mailz) {
        this.mailz = mailz;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="zaposleni")
//    public Set<Angazovan> getAngazovans() {
//        return this.angazovans;
//    }
    
//    public void setAngazovans(Set<Angazovan> angazovans) {
//        this.angazovans = angazovans;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zaposleni pojo = (Zaposleni) o;

        if (zanimanje != null ? !zanimanje.equals(pojo.zanimanje) : pojo.zanimanje != null) return false;
        if (jmbz != null ? !jmbz.equals(pojo.jmbz) : pojo.jmbz != null) return false;
        if (imez != null ? !imez.equals(pojo.imez) : pojo.imez != null) return false;
        if (przz != null ? !przz.equals(pojo.przz) : pojo.przz != null) return false;
        if (adrz != null ? !adrz.equals(pojo.adrz) : pojo.adrz != null) return false;
        if (gradz != null ? !gradz.equals(pojo.gradz) : pojo.gradz != null) return false;
        if (zipz != null ? !zipz.equals(pojo.zipz) : pojo.zipz != null) return false;
        if (telz != null ? !telz.equals(pojo.telz) : pojo.telz != null) return false;
        if (mailz != null ? !mailz.equals(pojo.mailz) : pojo.mailz != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (zanimanje != null ? zanimanje.hashCode() : 0);
        result = 31 * result + (jmbz != null ? jmbz.hashCode() : 0);
        result = 31 * result + (imez != null ? imez.hashCode() : 0);
        result = 31 * result + (przz != null ? przz.hashCode() : 0);
        result = 31 * result + (adrz != null ? adrz.hashCode() : 0);
        result = 31 * result + (gradz != null ? gradz.hashCode() : 0);
        result = 31 * result + (zipz != null ? zipz.hashCode() : 0);
        result = 31 * result + (telz != null ? telz.hashCode() : 0);
        result = 31 * result + (mailz != null ? mailz.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idz").append("='").append(getIdz()).append("', ");
        sb.append("zanimanje").append("='").append(getZanimanje()).append("', ");
        sb.append("jmbz").append("='").append(getJmbz()).append("', ");
        sb.append("imez").append("='").append(getImez()).append("', ");
        sb.append("przz").append("='").append(getPrzz()).append("', ");
        sb.append("adrz").append("='").append(getAdrz()).append("', ");
        sb.append("gradz").append("='").append(getGradz()).append("', ");
        sb.append("zipz").append("='").append(getZipz()).append("', ");
        sb.append("telz").append("='").append(getTelz()).append("', ");
        sb.append("mailz").append("='").append(getMailz()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
