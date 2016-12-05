package by.fpmi.pharmacy.services.impl;

import by.fpmi.pharmacy.dao.QuestionDao;
import by.fpmi.pharmacy.model.Question;
import by.fpmi.pharmacy.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public void saveQuestion(Question question) {
        questionDao.save(question);
    }

    @Override
    public Question getQuestion(long id) {
        return questionDao.getQuestion(id);
    }

    @Override
    public void deleteQuestion(long id) {
        questionDao.deleteQuestion(id);
    }

    @Override
    public List<Question> listQuestions() {
        return questionDao.listQuestions();
    }
}
