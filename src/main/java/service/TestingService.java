package service;

import persistence.model.Question;

import java.util.List;

public interface TestingService {
    void startTest(List<Question> questions);
}
