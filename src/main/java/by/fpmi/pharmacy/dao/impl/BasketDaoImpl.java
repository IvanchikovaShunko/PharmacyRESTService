package by.fpmi.pharmacy.dao.impl;

import by.fpmi.pharmacy.dao.BasketDao;
import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Subscription;
import org.hibernate.SessionFactory;
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
        List a = sessionFactory.getCurrentSession().createQuery("FROM Basket").list();
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
    public void delete(int id) {
        Basket basket = getById(id);
        if (null != basket) {
            sessionFactory.getCurrentSession().delete(basket);
        }
    }

    @Override
    public List<Basket> listBaskets() {
        return null;
    }
}
