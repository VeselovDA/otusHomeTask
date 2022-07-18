package com.example;

import com.example.service.QuestionService;
import com.example.service.TestingService;
import com.example.util.QuestionUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;


public class TestServiceImplTest extends BaseTest {
    @Autowired
    private TestingService testingService;
    @MockBean
    private QuestionService questionService;
    @Test
    void startTest(){
        when(questionService.getAllQuestion()).thenReturn(QuestionUtil.createQuestionList());
        testingService.startTest();

    }
}
