package com.example.service.impl;

import com.example.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.example.persistence.model.Question;
import com.example.service.TestingService;
import com.example.util.ConsoleReader;

import java.util.List;
import java.util.Locale;

@Service("testingService")
@PropertySource("classpath:application.yaml")
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {
    private final QuestionService questionService;
    private final MessageSource messageSource;
    @Value("${locale}")
    private  Locale locale;
    @Value("${edgePassage}")
    private Integer edgePassage;
    @Override
    public void startTest() {
        var questions=questionService.getAllQuestion();
        var currentCountRightAnswer=0d;

        for (var question:questions) {
            if(getAnswer(question)){
                currentCountRightAnswer++;
            }
        }
        var result=(currentCountRightAnswer/questions.size())*100;
        if(result>edgePassage){
            System.out.println(messageSource.getMessage("congratulation",new String[]{String.valueOf(result)}, locale ));
        } else {
            System.out.println(messageSource.getMessage("failed",new String[]{String.valueOf(result)}, locale ));
        }
    }
    private boolean getAnswer(Question question){
        System.out.println(question.getQuestion());
        System.out.println(messageSource.getMessage("write_answer",new String[]{}, locale ));
        var answerString = ConsoleReader.readConsole();
        var answers = List.of(answerString.split(" "));
        return question.getRightAnswers().containsAll(answers);
    }
}
