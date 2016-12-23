package by.fpmi.pharmacy.dao;

import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Medicine;

import java.util.List;

/**
 * Created by annashunko
 */
public interface BasketDao {
    Basket getById(int id);
    Basket getByUserId(int id);
    void update(Basket basket);
    Basket save(Basket basket);
    void removeMedicine(Basket basket, Medicine medicine);

    void clearBasket(Basket basket);

    void delete(int id);
}
