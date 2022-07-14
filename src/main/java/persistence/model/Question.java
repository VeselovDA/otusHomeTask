package persistence.model;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private final String question;
    private final List<String> rightAnswers;
    private final List<String> falseAnswers;


}
