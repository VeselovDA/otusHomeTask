package com.example.service;


import com.example.persistence.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();

    Question getByQuestion(String question);
}
