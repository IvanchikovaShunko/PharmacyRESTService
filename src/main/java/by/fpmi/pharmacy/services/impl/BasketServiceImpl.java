package by.fpmi.pharmacy.services.impl;

import by.fpmi.pharmacy.dao.BasketDao;
import by.fpmi.pharmacy.dao.UserDao;
import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Medicine;
import by.fpmi.pharmacy.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by annashunko
 */
@Service("basketService")
@Transactional
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketDao basketDao;

    @Override
    public Basket getById(int id) {
        return basketDao.getById(id);
    }

    @Override
    public Basket getByUserId(int id) {
        return basketDao.getByUserId(id);
    }

    @Override
    public void update(Basket basket) {
        basketDao.update(basket);
    }

    @Override
    public Basket save(Basket basket) {
        return basketDao.save(basket);
    }

    @Override
    public void delete(int id) {
        basketDao.delete(id);
    }

    @Override
    public void removeMedicine(Basket basket, Medicine medicine) {
        basketDao.removeMedicine(basket, medicine);
    }

    @Override
    public void clearBasket(Basket basket) {
        basketDao.clearBasket(basket);
    }
}
