package com.example.util;

import com.example.persistence.model.Question;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class QuestionUtil {
    private static final int TEST_LIST_SIZE=3;

    private QuestionUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static List<Question> createQuestionList(){
        return IntStream.range(0, TEST_LIST_SIZE).mapToObj(i->createQuestion(String.valueOf(i))).collect(Collectors.toList());
    }
    public static Question createQuestion(String suffix){
        var questionString="testQuestion"+suffix;
        var rightAnswer="rightAnswer"+suffix;
        var falseAnswer="rightAnswer"+suffix;
        var rightAnswers = IntStream.range(0, TEST_LIST_SIZE).mapToObj(i -> rightAnswer + "_" + i).collect(Collectors.toList());
        var falseAnswers = IntStream.range(0, TEST_LIST_SIZE).mapToObj(i -> falseAnswer + "_" + i).collect(Collectors.toList());
        return new Question(questionString,rightAnswers,falseAnswers);
    }
    public static Question createQuestion(){
       return createQuestion("");
    }
}
