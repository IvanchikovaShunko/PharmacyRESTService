package by.fpmi.pharmacy.dao;

import by.fpmi.pharmacy.model.Subscription;

import java.util.List;

/**
 * Created by annashunko
 */
public interface SubscriptionDao {
    Subscription getById(int id);
    Subscription getByUserId(int userId);
    void update(Subscription subscription);
    Subscription save(Subscription subscription);
    void delete(int id);
}
