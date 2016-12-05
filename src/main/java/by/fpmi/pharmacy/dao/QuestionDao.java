package by.fpmi.pharmacy.dao;


import by.fpmi.pharmacy.model.Question;

import java.util.List;

/**
 * Created by user on 12.11.2015.
 */
public interface QuestionDao {
    void update(Question question);
    Question save(Question question);
    void deleteQuestion(long id);
    Question getQuestion(long id);
    List<Question> listQuestions();
}
