package by.fpmi.pharmacy.services.impl;

import by.fpmi.pharmacy.dao.SubscriptionDao;
import by.fpmi.pharmacy.model.Subscription;
import by.fpmi.pharmacy.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by annashunko
 */
@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionDao subscriptionDao;

    @Override
    public Subscription getById(int id) {
        return subscriptionDao.getById(id);
    }

    @Override
    public Subscription getByUserId(int userId) {
        return subscriptionDao.getByUserId(userId);
    }

    @Override
    public void update(Subscription subscription) {
        subscriptionDao.update(subscription);
    }

    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionDao.save(subscription);
    }

    @Override
    public void delete(int id) {
        subscriptionDao.delete(id);
    }
}
