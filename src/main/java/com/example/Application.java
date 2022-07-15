package com.example;

import com.example.service.TestingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var context =  SpringApplication.run(Application.class);

        var testingService = (TestingService) context.getBean("testingService");

        testingService.startTest();
    }
}
