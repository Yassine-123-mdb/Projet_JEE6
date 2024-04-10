package dao;

import java.util.List;
import metier.entities.SmartPhone;

public interface ISmartPhoneDao {
    public SmartPhone save(SmartPhone smartPhone);
    public List<SmartPhone> smartphonesParMC(String mc);
    public SmartPhone getSmartPhone(Long id);
    public SmartPhone updateSmartPhone(SmartPhone smartPhone);
    public void deleteSmartPhone(Long id);
}
