package dao;

import entity.EnterHistory;
import entity.Scanner;
import entity.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class EntityHistoryDAOImpl implements EnterHistoryDAO {

    private UserDAOImpl userDAO;

    public EntityHistoryDAOImpl() {
        userDAO = new UserDAOImpl();
    }


    @Override
    public void addActivity(EnterHistory enterHistory, Long personId, Scanner scanner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        User user = userDAO.findUserById(personId);
        enterHistory.setUser(user);
        enterHistory.setScanner(scanner);
        session.persist(enterHistory);
        session.getTransaction().commit();
        session.close();
    }
}
