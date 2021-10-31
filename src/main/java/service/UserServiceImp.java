package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao DAO;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return DAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return DAO.getUser(id);
    }

    @Override
    @Transactional
    public void add(User user) {
        DAO.add(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        DAO.edit(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        DAO.delete(id);
    }
}
