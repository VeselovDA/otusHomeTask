package service;


import persistence.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();

    Question getByQuestion(String question);
}
