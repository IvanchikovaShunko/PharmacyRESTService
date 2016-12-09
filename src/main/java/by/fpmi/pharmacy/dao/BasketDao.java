package by.fpmi.pharmacy.dao;

import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Subscription;

import java.util.List;

/**
 * Created by annashunko
 */
public interface BasketDao {
    Basket getById(int id);
    void update(Basket basket);
    Subscription save(Basket basket);
    void delete(int id);
    List<Basket> listBaskets();
}
