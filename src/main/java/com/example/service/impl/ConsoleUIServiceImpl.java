package com.example.service.impl;

import com.example.util.ConsoleReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.example.service.UIService;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service("printService")
@RequiredArgsConstructor
public class ConsoleUIServiceImpl implements UIService {
    private final MessageSource messageSource;
    @Value("${locale}")
    private Locale locale;

    @Override
    public void print(Object object) {
        System.out.println(object);
    }

    @Override
    public <T> void printList(List<T> objects) {
        objects.forEach(System.out::println);
    }

    public Map<String,List<String>> readConsole(List<String> questions){
        return questions.stream().collect(Collectors.toMap(question->question, this::readAnswerOnConsole));
    }


    private List<String> readAnswerOnConsole(String question){
            System.out.println(question);
            System.out.println(messageSource.getMessage("write_answer",new String[]{}, locale ));
            var answerString = ConsoleReader.readConsole();
            return List.of(answerString.split(" "));
        }
    }

