package com.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.persistence.mapper.QuestionMapper;
import com.example.persistence.model.Question;
import com.example.service.QuestionService;
import com.example.service.ReaderService;

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
