package com.example;

import com.example.service.QuestionService;
import com.example.service.ReaderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;


import static org.mockito.Mockito.when;

public class QuestionServiceImplTest extends BaseTest{
    private static final String CORRECT_RESOURCE_PATH="question-answer.csv";
    private static final String INCORRECT_RESOURCE_PATH="question-answer-incorrect.csv";

    @Autowired
    ReaderService readerService;
    @Autowired
    QuestionService questionService;

    @Test
    void readAllQuestions(){
        ReflectionTestUtils.setField(readerService, "resourcePath", CORRECT_RESOURCE_PATH);
        var questions = questionService.getAllQuestion();
        Assertions.assertEquals(2,questions.size());
    }
    @Test
    void readAllQuestionsIncorrect(){
        ReflectionTestUtils.setField(readerService, "resourcePath", INCORRECT_RESOURCE_PATH);
        var questions = questionService.getAllQuestion();
        Assertions.assertEquals(2,questions.size());
    }
}
