package me.cd.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import me.cd.overflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();
}
