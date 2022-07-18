package com.example.service.impl;

import com.example.service.UIService;
import com.example.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.example.persistence.model.Question;
import com.example.service.TestingService;

import java.util.Locale;
import java.util.stream.Collectors;

@Service("testingService")
@PropertySource("classpath:application.yaml")
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {
    private final QuestionService questionService;
    private final MessageSource messageSource;
    private final UIService UIService;
    @Value("${locale}")
    private  Locale locale;
    @Value("${edgePassage}")
    private Integer edgePassage;
    @Override
    public boolean startTest() {
        var questions=questionService.getAllQuestion();
        var currentCountRightAnswer=0d;

        var stringListMap = UIService.readConsole(questions.stream().map(Question::getQuestion).collect(Collectors.toList()));
        for (var question:questions) {
            if(question.getRightAnswers().containsAll(stringListMap.get(question.getQuestion()))){
                currentCountRightAnswer++;
            }
        }
        var result=(currentCountRightAnswer/questions.size())*100;
        if(result>=edgePassage){
            System.out.println(messageSource.getMessage("congratulation",new String[]{String.valueOf(result)}, locale ));
            return true;
        } else {
            System.out.println(messageSource.getMessage("failed",new String[]{String.valueOf(result)}, locale ));
            return false;
        }
    }
}
