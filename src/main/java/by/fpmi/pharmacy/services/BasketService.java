package by.fpmi.pharmacy.services;

import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Medicine;

import java.util.List;

/**
 * Created by annashunko
 */
public interface BasketService {
    Basket getById(int id);
    Basket getByUserId(int id);
    void update(Basket basket);
    Basket save(Basket basket);
    void delete(int id);
    void removeMedicine(Basket basket, Medicine medicine);

}
