package dao;

import metier.entities.SmartPhone;

public class TestDao {
    public static void main(String[] args) {
        SmartPhoneDaoImpl smartPhoneDao = new SmartPhoneDaoImpl();
        //SmartPhone smartPhone = smartPhoneDao.save(new SmartPhone("Infinix Hot 10", "Noir", 700, 4, 64));
        // System.out.println(smartPhone);
        // List<SmartPhone> smartPhones = smartPhoneDao.smartphonesParMC("Infinix");
        // for (SmartPhone s : smartPhones)
        //     System.out.println(s);
    }
}
