package by.fpmi.pharmacy.services;



import by.fpmi.pharmacy.model.Question;

import java.util.List;

public interface QuestionService {
    void saveQuestion(Question question);
    Question getQuestion(long id);
    void deleteQuestion(long id);
    List<Question> listQuestions();
}
