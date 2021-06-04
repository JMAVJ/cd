package me.cd.views.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.cd.views.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
