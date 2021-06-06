package md.cd.events.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import md.cd.events.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    Optional<User> findById(Long id);
}
