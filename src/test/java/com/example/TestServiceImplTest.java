package com.example;

import com.example.service.QuestionService;
import com.example.service.TestingService;
import com.example.service.UIService;
import com.example.util.QuestionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



public class TestServiceImplTest extends BaseTest {
    @Autowired
    private TestingService testingService;
    @MockBean
    private QuestionService questionService;
    @MockBean
    private UIService UIService;
    @Test
    void startTestRightAnswer(){
        var questionList = QuestionUtil.createQuestionList();
        var fullRightAnswer = QuestionUtil.createFullRightAnswer(questionList);
        when(questionService.getAllQuestion()).thenReturn(questionList);
        when(UIService.readConsole(any())).thenReturn(fullRightAnswer);
        Assertions.assertTrue(testingService.startTest());
    }

    @Test
    void startTestFalseAnswer(){
        var questionList = QuestionUtil.createQuestionList();
        var fullFalseAnswer = QuestionUtil.createFullFalseAnswer(questionList);
        when(questionService.getAllQuestion()).thenReturn(questionList);
        when(UIService.readConsole(any())).thenReturn(fullFalseAnswer);
        Assertions.assertFalse(testingService.startTest());
    }
}
