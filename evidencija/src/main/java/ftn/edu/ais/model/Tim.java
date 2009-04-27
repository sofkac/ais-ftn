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
@Table(name="tim",catalog="evidencija")
public class Tim extends BaseObject implements Serializable {
    private Long idt;
    private String nazt;
  //  private Set<Pripada> pripadas = new HashSet<Pripada>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdt() {
        return this.idt;
    }
    
    public void setIdt(Long idt) {
        this.idt = idt;
    }
    
    @Column(name="nazt", nullable=false, length=30)
    public String getNazt() {
        return this.nazt;
    }
    
    public void setNazt(String nazt) {
        this.nazt = nazt;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tim")
  //  public Set<Pripada> getPripadas() {
    //    return this.pripadas;
   // }
    
   // public void setPripadas(Set<Pripada> pripadas) {
    //    this.pripadas = pripadas;
    //}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tim pojo = (Tim) o;

        if (nazt != null ? !nazt.equals(pojo.nazt) : pojo.nazt != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (nazt != null ? nazt.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idt").append("='").append(getIdt()).append("', ");
        sb.append("nazt").append("='").append(getNazt()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}