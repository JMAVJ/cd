package me.cd.licenses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.licenses.models.Person;
import me.cd.licenses.repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (!person.isPresent()) {
            return null;
        }
        return person.get();
    }

    public Person add(Person person) {
        return personRepository.save(person);
    }
}
