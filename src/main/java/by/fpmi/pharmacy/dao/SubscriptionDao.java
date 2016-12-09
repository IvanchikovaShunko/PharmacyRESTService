package by.fpmi.pharmacy.dao;

import by.fpmi.pharmacy.model.Medicine;
import by.fpmi.pharmacy.model.Subscription;

import java.util.List;

/**
 * Created by annashunko
 */
public interface SubscriptionDao {
    Subscription getById(int id);
    void update(Subscription subscription);
    Subscription save(Subscription subscription);
    void delete(int id);
    List<Subscription> listSubscriptions();
}
