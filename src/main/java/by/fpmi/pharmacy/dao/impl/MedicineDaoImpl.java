package by.fpmi.pharmacy.dao.impl;

import by.fpmi.pharmacy.dao.MedicineDao;
import by.fpmi.pharmacy.model.Medicine;
import by.fpmi.pharmacy.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by annashunko
 */
@Repository
public class MedicineDaoImpl implements MedicineDao {
    private static String GET_MEDICINE_BY_ID = "FROM Medicine WHERE id=:id";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Medicine getById(int id) {
        List medicines = sessionFactory.getCurrentSession().createQuery(GET_MEDICINE_BY_ID)
                .setParameter("id", id).list();
        if (medicines.size() > 0) {
            return (Medicine) medicines.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void update(Medicine medicine) {
        //TODO
    }

    @Override
    public Medicine save(Medicine medicine) {
        //TODO
        return null;
    }

    @Override
    public void delete(int id) {
    //TODO
    }

    @Override
    public List<Medicine> listMedicines() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Medicine.class);
        c.addOrder(Order.asc("nameMedicine"));
        return c.list();
    }
}
