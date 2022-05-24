package dao;

import entity.MCU;
import entity.Scanner;
import entity.User;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class McuDAOImpl implements McuDAO {

    @Override
    public void add(MCU mcu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(mcu);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public MCU findByAddress(String address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from MCU  where address=:addressParam");
        query.setParameter("addressParam", address);
        MCU mcu = (MCU) query.getSingleResult();
        return mcu;
    }
}
