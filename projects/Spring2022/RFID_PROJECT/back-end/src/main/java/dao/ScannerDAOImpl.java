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
    public void removeScannerByInnerId(Long innerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("delete Scanner where innerId= :ID");
        query.setParameter("ID", innerId);
        query.executeUpdate();
        session.close();
    }

    @Override
    public void removeScannerByNumber(String hardwareNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("delete Scanner where hardwareNumber= :number");
        query.setParameter("number", hardwareNumber);
        query.executeUpdate();
        session.close();
    }

    @Override
    public void updateScanner(Role newRole, Long innerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("update Scanner set role=:roleParam where innerId=:innerIdParam");
        query.setParameter("roleParam", newRole);
        query.setParameter("innerIdParam", innerId);
        query.executeUpdate();
        session.close();
    }

    @Override
    public Scanner findScannerByNumber(String hardwareNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Scanner where hardwareNumber=:hardwareNumberParam");
        query.setParameter("hardwareNumberParam", hardwareNumber);
        Scanner scanner = (Scanner) query.getSingleResult();
        return scanner;
    }

    @Override
    public List<Scanner> getAllScanners() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Scanner");
        List<Scanner> scannersList = query.getResultList();
        return scannersList;
    }
}
