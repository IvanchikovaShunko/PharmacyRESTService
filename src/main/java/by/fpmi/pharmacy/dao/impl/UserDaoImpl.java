package by.fpmi.pharmacy.dao.impl;

import by.fpmi.pharmacy.dao.UserDao;
import by.fpmi.pharmacy.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByUsername(String username) {
        List<User> users = new ArrayList<User>();
        users = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=?").setParameter(0, username).list();
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    @Override
    public User getUserById(int id) {
        List<User> users = new ArrayList<User>();
        users = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id=?").setParameter(0, id).list();
        if (users.size() > 0) {
            return users.get(0);
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
        User u = getByUsername(user.getUsername());
        if (u != null) {
            sessionFactory.getCurrentSession().merge(user);
            return user;
        }
//        user.setPassword(new CustomPasswordEncoder("sha-256").encodePassword(user.getUsername(), user.getPassword()));

        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public List<User> listUsers() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
        c.addOrder(Order.asc("username"));
        return c.list();
    }

    @Override
    public void delete(String username) {
        User user = getByUsername(username);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }

    }
}
