package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.SmartPhone;

public class SmartPhoneModele {
    private String motCle;
    List<SmartPhone> smartPhones = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<SmartPhone> getSmartPhones() {
        return smartPhones;
    }

    public void setSmartPhones(List<SmartPhone> smartPhones) {
        this.smartPhones = smartPhones;
    }
}
