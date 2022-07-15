package com.example;

import com.example.service.PrintService;
import com.example.service.QuestionService;
import com.example.service.TestingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.example.persistence.model.Question;


import java.util.List;

@ComponentScan
@Component
public class Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Application.class);

        var printService = (PrintService) context.getBean("printService");
        var questionService = (QuestionService) context.getBean("questionService");
        var testingService = (TestingService) context.getBean("testingService");

        List<Question> allQuestion = questionService.getAllQuestion();
        printService.printList(allQuestion);
        testingService.startTest(allQuestion);
    }
}
