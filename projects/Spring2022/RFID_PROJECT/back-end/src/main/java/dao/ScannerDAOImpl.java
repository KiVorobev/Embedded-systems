package dao;

import entity.Scanner;
import enums.Role;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class ScannerDAOImpl implements ScannerDAO {

    @Override
    public void addScanner(Scanner scanner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(scanner);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void removeScannerByNumber(String hardwareNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Scanner scanner = findScannerByNumber(hardwareNumber);
        session.remove(scanner);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateScanner(Role newRole, String hardwareNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("update Scanner set role=:roleParam where hardwareNumber=:hardwareNumParam");
        query.setParameter("roleParam", newRole);
        query.setParameter("hardwareNumParam", hardwareNumber);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Scanner findScannerByNumber(String hardwareNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Scanner where hardwareNumber=:hardwareNumberParam");
        query.setParameter("hardwareNumberParam", hardwareNumber);
        Scanner scanner = (Scanner) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return scanner;
    }

    @Override
    public List<Scanner> getAllScanners() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Scanner");
        List<Scanner> scannersList = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return scannersList;
    }
}
