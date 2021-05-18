package me.cd.licenses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cd.licenses.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}
