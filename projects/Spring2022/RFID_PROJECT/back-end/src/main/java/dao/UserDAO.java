package dao;

import entity.User;

public interface UserDAO {

    void addUser(User user);

    void removeUser(Long id);

    void updateUser(Long id, User user);

    User findUserById(Long id);

}
