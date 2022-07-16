package com.example.service.impl;

import com.example.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.example.persistence.model.Question;
import com.example.service.TestingService;
import com.example.util.ConsoleReader;

import java.util.List;

@Service("testingService")
@PropertySource("classpath:application.yaml")
@RequiredArgsConstructor
public class TestingServiceImpl implements TestingService {
    private final QuestionService questionService;
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
            System.out.println("Congratulation! Your result:"+result +"%");
        } else {
            System.out.println("Test has been failed Your result: "+result +"%");
        }
    }
    private boolean getAnswer(Question question){
        System.out.println(question.getQuestion());
        var answerString = ConsoleReader.readConsole();
        var answers = List.of(answerString.split(" "));
        return question.getRightAnswers().containsAll(answers);
    }
}
