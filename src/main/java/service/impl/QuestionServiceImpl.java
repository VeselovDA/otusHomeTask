package service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import persistence.mapper.QuestionMapper;
import persistence.model.Question;
import service.QuestionService;
import service.ReaderService;

import java.util.List;
@Service("questionService")
@RequiredArgsConstructor

public class QuestionServiceImpl implements QuestionService {
    private final ReaderService readerService;
    private final QuestionMapper questionMapper;

    @Override
    public List<Question> getAllQuestion() {
        return questionMapper.toQuestions(readerService.readAllQuestions());
    }

    @Override
    public Question getByQuestion(String questionStr) {
        return getAllQuestion().stream()
                .filter(question -> question.getQuestion().equals(questionStr))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Question " + questionStr + " not found"));
    }
}
