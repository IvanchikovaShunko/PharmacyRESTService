package by.fpmi.pharmacy.services;

import by.fpmi.pharmacy.model.Subscription;

/**
 * Created by annashunko
 */
public interface SubscriptionService {
    Subscription getById(int id);
    Subscription getByUserId(int userId);
    void update(Subscription subscription);
    Subscription save(Subscription subscription);
    void delete(int id);
}
