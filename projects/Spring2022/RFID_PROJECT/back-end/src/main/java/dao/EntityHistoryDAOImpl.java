package dao;

import entity.EnterHistory;
import entity.Scanner;
import entity.User;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class EntityHistoryDAOImpl implements EnterHistoryDAO {

    private UserDAOImpl userDAO;

    public EntityHistoryDAOImpl() {
        userDAO = new UserDAOImpl();
    }


    @Override
    public void addActivity(Long personId, Scanner scanner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        User user = userDAO.findUserById(personId);
        EnterHistory enterHistory = new EnterHistory();
        enterHistory.setUser(user);
        enterHistory.setScanner(scanner);
        session.persist(enterHistory);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<EnterHistory> getLastTwentyRows() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from EnterHistory order by enterActivity desc");
        query.setFirstResult(0);
        query.setMaxResults(20);
        List<EnterHistory> activitiesList = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return activitiesList;
    }

    @Override
    public void deleteActivityList(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("delete EnterHistory where user.id =: userID");
        query.setParameter("userID", userId);
        query.executeUpdate();
        session.close();
    }
}
