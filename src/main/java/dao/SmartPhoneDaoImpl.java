package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.SmartPhone;
import util.JPAutil;

public class SmartPhoneDaoImpl implements ISmartPhoneDao {

    private EntityManager entityManager = JPAutil.getEntityManager("TP5_SmartPhone_2");

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(smartPhone);
        tx.commit();
        return smartPhone;
    }

    @Override
    public List<SmartPhone> smartphonesParMC(String mc) {
        List<SmartPhone> smartphones = entityManager.createQuery("select s from SmartPhone s where s.marque like :mc").setParameter("mc", "%" + mc + "%").getResultList();
        return smartphones;
    }

    @Override
    public SmartPhone getSmartPhone(Long id) {
        return entityManager.find(SmartPhone.class, id);
    }

    @Override
    public SmartPhone updateSmartPhone(SmartPhone smartPhone) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(smartPhone);
        tx.commit();
        return smartPhone;
    }

    @Override
    public void deleteSmartPhone(Long id) {
        SmartPhone smartPhone = entityManager.find(SmartPhone.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(smartPhone);
        entityManager.getTransaction().commit();
    }
}
