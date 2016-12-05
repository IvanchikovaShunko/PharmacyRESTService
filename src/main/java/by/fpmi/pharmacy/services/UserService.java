package by.fpmi.pharmacy.services;


import by.fpmi.pharmacy.model.User;

import java.util.List;

public interface UserService {
    User readUserByUsername(String username);
    void update(User user);
    void save(User user);
    void delete(String username);
    User registerNewUserAccount(User accountDao) throws NullPointerException;
    List<User> listUsers();
}
