package com.example.persistence.mapper;

import com.example.persistence.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionMapper {

    public List<Question> toQuestions(List<String[]> stringList) {
        var questionList = new ArrayList<Question>();
        var notValidList = new ArrayList<String[]>();

        stringList.stream()
                .filter(strings -> strings.length != 3)
                .forEach(strings -> {
                    notValidList.add(strings);
                    System.out.println("невалидная строка " + Arrays.toString(strings));
                });
        stringList.removeAll(notValidList);//удаление невалидных строк

        stringList.forEach(strings -> {
            if (questionList.stream().anyMatch(question -> question.getQuestion().equals(strings[0]))) {
                questionList.stream()
                        .filter(question -> question.getQuestion().equals(strings[0]))
                        .findFirst()
                        .ifPresent(question -> recordAnswer(question, strings));
            } else {
                questionList.add(createQuestion(strings));
            }
        });
        return questionList;
    }

    private void recordAnswer(Question question, String[] strings) {
        if (Boolean.parseBoolean(strings[2])) {
            question.getRightAnswers().add(strings[1]);
        } else {
            question.getFalseAnswers().add(strings[1]);
        }
    }

    private Question createQuestion(String[] strings) {
        var question = new Question(strings[0], new ArrayList<>(), new ArrayList<>());
        recordAnswer(question, strings);
        return question;
    }
}
