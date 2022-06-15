package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;
import org.jetbrains.annotations.Nullable;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAOImpl();
    }

    public void add(User user) {
        userDAO.addUser(user);
    }

    public void deleteUser(Long id) {
        userDAO.removeUser(id);
    }

    public void updateUser(Long id, User user) {
        userDAO.updateUser(id, user);
    }

    @Nullable
    public User getById(Long id) {
        User user = userDAO.findUserById(id);
        return user;
    }

    @Nullable
    public User getByCardId(String cardId) {
        User user = userDAO.findByCardId(cardId);
        return user;
    }

    public int getUserPriorityByCardId(User user) {
        return user.getRole().priority;
    }
}
