package com.example.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.example.persistence.model.Question;
import com.example.service.TestingService;
import com.example.util.ConsoleReader;

import java.util.List;

@Service("testingService")
@PropertySource("classpath:application.properties")
public class TestingServiceImpl implements TestingService {
    @Value("${edgePassage}")
    private Integer edgePassage;
    @Override
    public void startTest(List<Question> questions) {
        var currentCountRightAnswer= new AtomicReference<Double>();
        currentCountRightAnswer.getAndSet(0d);
        questions.forEach(question -> {
            if(getAnswer(question)){
                currentCountRightAnswer.getAndSet(currentCountRightAnswer.get()+1);
            }
        });
        var result=(currentCountRightAnswer.get()/questions.size())*100;
        if(result>edgePassage){
            System.out.println("Congratulation! Your result:"+result +"%");
        } else {
            System.out.println("Test has been failed Your result: "+result +"%");
        }
    }
    private boolean getAnswer(Question question){
        System.out.println(question.getQuestion());
        String answerString = ConsoleReader.readConsole();
        List<String> answers = List.of(answerString.split(" "));
        return question.getRightAnswers().containsAll(answers);
    }
}