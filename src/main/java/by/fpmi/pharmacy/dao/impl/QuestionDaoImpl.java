package by.fpmi.pharmacy.dao.impl;

import by.fpmi.pharmacy.dao.QuestionDao;
import by.fpmi.pharmacy.model.Question;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void update(Question question) {
        sessionFactory.getCurrentSession().update(question);
    }

    @Override
    public Question save(Question question) {
        Question question1 = getQuestion(question.getQuestionID());
        if (question1 != null) {
            sessionFactory.getCurrentSession().update(question);
            return  question;
        }
        sessionFactory.getCurrentSession().save(question);
        return question;
    }

    @Override
    public void deleteQuestion(long id) {
        Question question = getQuestion(id);
        if(question != null)
            sessionFactory.getCurrentSession().delete(question);
    }

    @Override
    public List<Question> listQuestions() {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Question.class);
        c.addOrder(Order.asc("questionID"));
        return  c.list();
    }

    @Override
    public Question getQuestion(long id) {
        List<Question> list;

        list = sessionFactory.getCurrentSession()
                .createQuery("from Question where questionID=?")
                .setParameter(0, id)
                .list();

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }


}
