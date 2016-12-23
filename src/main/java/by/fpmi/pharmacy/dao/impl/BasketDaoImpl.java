package by.fpmi.pharmacy.dao.impl;

import by.fpmi.pharmacy.dao.BasketDao;
import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Medicine;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by annashunko
 */
@Repository
public class BasketDaoImpl implements BasketDao {
    private static String GET_BASKET_BY_ID = "FROM Basket WHERE idBasket=:id";
    private static String GET_BASKET_BY_USER_ID = "FROM Basket WHERE idUser.id=:idUser";

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Basket getById(int id) {
        List baskets = sessionFactory.getCurrentSession().createQuery(GET_BASKET_BY_ID)
                .setParameter("id", id).list();
        if (baskets.size() > 0) {
            return (Basket) baskets.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Basket getByUserId(int id) {
        List baskets = sessionFactory.getCurrentSession().createQuery(GET_BASKET_BY_USER_ID)
                .setParameter("idUser", id).list();
        if (baskets.size() > 0) {
            return (Basket) baskets.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void update(Basket basket) {
        sessionFactory.getCurrentSession().update(basket);
    }

    @Override
    public Basket save(Basket basket) {
        if (basket.getIdBasket() != null) {
            Basket b = getById(basket.getIdBasket());
            if (b != null) {
                sessionFactory.getCurrentSession().merge(basket);
                return basket;
            }
        }
        sessionFactory.getCurrentSession().save(basket);
        return basket;
    }

    @Override
    public void removeMedicine(Basket basket, Medicine medicine) {
        //sessionFactory.getCurrentSession().delete(medicine);
        basket.getMedicines().remove(medicine);
        sessionFactory.getCurrentSession().merge(basket);
    }

    @Override
    public void clearBasket(Basket basket) {
        basket.getMedicines().clear();
        sessionFactory.getCurrentSession().merge(basket);
    }

    @Override
    public void delete(int id) {
        Basket basket = getById(id);
        if (null != basket) {
            sessionFactory.getCurrentSession().delete(basket);
        }
    }

}
