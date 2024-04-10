package metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "SMARTPHONE")
public class SmartPhone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SMARTPHONE")
    private Long idSmartPhone;

    @Column(name = "MARQUE")
    private String marque;

    @Column(name = "COULEUR")
    private String couleur;

    @Column(name = "PRIX")
    private double prix;

    @Column(name = "RAM")
    private int ram;

    @Column(name = "STOCKAGE")
    private int stockage;

 
    private Type type;

    public SmartPhone() {
        super();
    }

    public SmartPhone(String marque, String couleur, double prix, int ram, int stockage, Type type) {
        super();
        this.marque = marque;
        this.couleur = couleur;
        this.prix = prix;
        this.ram = ram;
        this.stockage = stockage;
        this.type = type;
    }

    public Long getIdSmartPhone() {
        return idSmartPhone;
    }

    public void setIdSmartPhone(Long idSmartPhone) {
        this.idSmartPhone = idSmartPhone;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStockage() {
        return stockage;
    }

    public void setStockage(int stockage) {
        this.stockage = stockage;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
