package dao;

import entity.DismissedEnterHistory;
import entity.EnterHistory;
import entity.Scanner;
import entity.User;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class DismissedEnterHistoryDAOImpl implements DismissedEnterHistoryDAO {

    private UserDAOImpl userDAO;

    public DismissedEnterHistoryDAOImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public void addDismissedActivity(Scanner scanner, String cardId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        DismissedEnterHistory dismissedEnterHistory = new DismissedEnterHistory();
        dismissedEnterHistory.setCardId(cardId);
        dismissedEnterHistory.setScanner(scanner);
        session.persist(dismissedEnterHistory);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<DismissedEnterHistory> getLastTwentyRows() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from DismissedEnterHistory order by enterActivity desc");
        query.setFirstResult(0);
        query.setMaxResults(20);
        List<DismissedEnterHistory> dismissedActivitiesList = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return dismissedActivitiesList;
    }
}
