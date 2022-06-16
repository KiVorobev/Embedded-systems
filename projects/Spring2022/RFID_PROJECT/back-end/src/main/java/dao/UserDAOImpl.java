package dao;

import entity.User;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;


public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUser(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        User user = findUserById(id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateUser(Long id, User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("update User set name=:nameParam ,surname=:surnameParam , patronymic=:patronymicParam , role=:roleParam where id=:ID");
        query.setParameter("nameParam", user.getName());
        query.setParameter("surnameParam", user.getSurname());
        query.setParameter("patronymicParam", user.getPatronymic());
        query.setParameter("roleParam", user.getRole());
        query.setParameter("ID", id);
        query.executeUpdate();
        session.close();
    }

    @Override
    public User findUserById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User findByCardId(String cardId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from User where cardId=:CardIdParam");
        query.setParameter("CardIdParam", cardId);
        List<User> user = (List<User>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        if (user.isEmpty()) return null;
        return user.get(0);
    }
}
