package service;

import dao.UserDAOImpl;
import entity.User;
import exception.DoesntExistException;

public class UserService {

    private UserDAOImpl userDAO;

    public UserService() {
        userDAO = new UserDAOImpl();
    }

    public void add(User user) {
        userDAO.addUser(user);
    }

    public User getById(Long id) throws DoesntExistException {
        User user = userDAO.findUserById(id);
        if (user==null) throw new DoesntExistException("There is no such user");
        return user;
    }

    public void deleteUser(Long id) {
        userDAO.removeUser(id);
    }

    public void updateUser(Long id, User user) {
        userDAO.updateUser(id, user);
    }

}
