package by.fpmi.pharmacy.services;

import by.fpmi.pharmacy.model.Subscription;

import java.util.List;

/**
 * Created by annashunko
 */
public interface SubscriptionService {
    Subscription getById(int id);
    List<Subscription> getUserSubscriptions(int userId);
    void update(Subscription subscription);
    Subscription save(Subscription subscription);
    void delete(int id);
}
