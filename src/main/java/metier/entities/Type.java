package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idT;
    private String nomT;
    @Temporal(TemporalType.DATE)
    private Date dateT;
    @OneToMany(mappedBy = "type")
    private List<SmartPhone> smartphones;

    public Type() {
        super();
    }

    public Type(String nomT, Date dateT) {
        super();
        this.nomT = nomT;
        this.dateT = dateT;
    }

    public Long getIdT() {
        return idT;
    }

    public void setIdT(Long idT) {
        this.idT = idT;
    }

    public String getNomT() {
        return nomT;
    }

    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    public Date getDateT() {
        return dateT;
    }

    public void setDateT(Date dateT) {
        this.dateT = dateT;
    }

    public List<SmartPhone> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(List<SmartPhone> smartphones) {
        this.smartphones = smartphones;
    }
}
