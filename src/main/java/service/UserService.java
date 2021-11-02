package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
    void add(User user);
    void edit(User user, long id);
    void delete(Long id);
}
