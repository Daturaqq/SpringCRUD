package dao;

import model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUser(Long id);
    void add(User user);
    void edit(User user);
    void delete(Long id);
}
