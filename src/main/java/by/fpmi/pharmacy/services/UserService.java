package by.fpmi.pharmacy.services;


import by.fpmi.pharmacy.model.User;

import java.util.List;

public interface UserService {
    User readUserByUsername(String username);
    User getUserById(int id);
    void update(User user);
    User save(User user);
    void delete(String username);
    User registerNewUserAccount(User accountDao) throws NullPointerException;
    List<User> listUsers();
    User find(String login, String password);

}
