package me.cd.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.overflow.models.Question;
import me.cd.overflow.repositories.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public Question getById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.isPresent() ? question.get() : null;
    }

    public Question add(Question question) {
        return questionRepository.save(question);
    }
}
