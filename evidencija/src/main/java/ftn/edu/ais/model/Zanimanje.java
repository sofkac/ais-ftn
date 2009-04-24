package ftn.edu.ais.model;

//import ftn.edu.ais.model.BaseObject;

//import java.util.HashSet;
//import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name="zanimanje",catalog="evidencija")
public class Zanimanje extends BaseObject implements Serializable {
    private Long idzan;
    private String nazzan;
    //private Set<Zaposleni> zaposlenis = new HashSet<Zaposleni>(0);
    //private Set<Pripada> pripadas = new HashSet<Pripada>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdzan() {
        return this.idzan;
    }
    
    public void setIdzan(Long idzan) {
        this.idzan = idzan;
    }
    
    @Column(name="nazzan", nullable=false, length=30)
    public String getNazzan() {
        return this.nazzan;
    }
    
    public void setNazzan(String nazzan) {
        this.nazzan = nazzan;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="zanimanje")
//    public Set<Zaposleni> getZaposlenis() {
//        return this.zaposlenis;
//    }
    
//    public void setZaposlenis(Set<Zaposleni> zaposlenis) {
//        this.zaposlenis = zaposlenis;
//    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="zanimanje")
//    public Set<Pripada> getPripadas() {
//        return this.pripadas;
//    }
    
//    public void setPripadas(Set<Pripada> pripadas) {
//        this.pripadas = pripadas;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zanimanje pojo = (Zanimanje) o;

        if (nazzan != null ? !nazzan.equals(pojo.nazzan) : pojo.nazzan != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (nazzan != null ? nazzan.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idzan").append("='").append(getIdzan()).append("', ");
        sb.append("nazzan").append("='").append(getNazzan()).append("', ");
        
        
        sb.append("]");
      
        return sb.toString();
    }

}
