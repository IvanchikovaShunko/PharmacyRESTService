package by.fpmi.pharmacy.dao.impl;

import by.fpmi.pharmacy.dao.SubscriptionDao;
import by.fpmi.pharmacy.model.Subscription;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by annashunko
 */
@Repository
public class SubscriptionDaoImpl implements SubscriptionDao{
    private static String GET_SUBSCRIPTION_BY_ID = "FROM Subscription WHERE idSubscription=:id";
    private static String GET_SUBSCRIPTION_BY_USER_ID = "FROM Subscription WHERE idUser.id=:idUser";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Subscription getById(int id) {
        List subscriptions = sessionFactory.getCurrentSession().createQuery(GET_SUBSCRIPTION_BY_ID)
                .setParameter("id", id).list();
        if (subscriptions.size() > 0) {
            return (Subscription) subscriptions.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Subscription> getUserSubscriptions(int userId) {
        List subscriptions = sessionFactory.getCurrentSession().createQuery(GET_SUBSCRIPTION_BY_USER_ID)
                .setParameter("idUser", userId).list();
        if (subscriptions.size() > 0) {
            return subscriptions;
        } else {
            return null;
        }
    }

    @Override
    public void update(Subscription subscription) {
        sessionFactory.getCurrentSession().update(subscription);
    }

    @Override
    public Subscription save(Subscription subscription) {
        if (subscription.getIdSubscription() != null) {
            Subscription b = getById(subscription.getIdSubscription());
            if (b != null) {
                sessionFactory.getCurrentSession().merge(subscription);
                return subscription;
            }
        }
        sessionFactory.getCurrentSession().save(subscription);
        return subscription;
    }

    @Override
    public void delete(int id) {
        Subscription subscription = getById(id);
        if (null != subscription) {
            sessionFactory.getCurrentSession().delete(subscription);
        }
    }

}
