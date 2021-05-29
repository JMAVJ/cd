package me.cd.overflow.services;

import org.springframework.stereotype.Service;

import me.cd.overflow.models.Answer;
import me.cd.overflow.models.Question;
import me.cd.overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer add(String answer, Question question) {
        return answerRepository.save(new Answer(answer, question));
    }
}
