package me.cd.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cd.overflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findAll();
    Tag findBySubjectEquals(String subject);
}
