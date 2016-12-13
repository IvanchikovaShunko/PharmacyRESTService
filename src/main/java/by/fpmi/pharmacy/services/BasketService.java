package by.fpmi.pharmacy.services;

import by.fpmi.pharmacy.model.Basket;

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
    List<Basket> listBaskets();
}
