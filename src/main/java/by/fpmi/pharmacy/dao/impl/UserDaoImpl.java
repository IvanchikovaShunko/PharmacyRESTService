package by.fpmi.pharmacy.dao.impl;

import by.fpmi.pharmacy.dao.UserDao;
import by.fpmi.pharmacy.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {
    private static String GET_USER_BY_USERNAME = "FROM User WHERE username=:username";
    private static String GET_USER_BY_ID = "FROM User WHERE id=:id";
    private static String FIND_USER_BY_LOGIN_PASSWORD = "from User where username = :username AND password = :password";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByUsername(String username) {
        List users = sessionFactory.getCurrentSession().createQuery(GET_USER_BY_USERNAME)
                .setParameter("username", username).list();
        if (users.size() > 0) {
            return (User) users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserById(int id) {
        List users = sessionFactory.getCurrentSession().createQuery(GET_USER_BY_ID)
                .setParameter("id", id).list();
        if (users.size() > 0) {
            return (User) users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User save(User user) {
        User u = getUserById(user.getId());
        if (u != null) {
            sessionFactory.getCurrentSession().merge(user);
            return user;
        }
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public List<User> listUsers() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
        c.addOrder(Order.asc("login"));
        return c.list();
    }

    @Override
    public User find(String username, String password) {
        Query query = sessionFactory.getCurrentSession().createQuery(FIND_USER_BY_LOGIN_PASSWORD)
                .setParameter("username", username)
                .setParameter("password", password);
        List<User> users = query.list();
        if (users.size() > 0) {
            return (User) users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void delete(String username) {
        User user = getByUsername(username);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }

    }
}
