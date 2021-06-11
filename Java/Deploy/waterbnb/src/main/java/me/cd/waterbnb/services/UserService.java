package me.cd.waterbnb.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import me.cd.waterbnb.models.User;
import me.cd.waterbnb.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        Optional<User> u = userRepository.findById(id);
        return u.isPresent() ? u.get() : null;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User add(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        User u = userRepository.findByEmail(email);
        if (u == null) {
            return false;
        }
        if (BCrypt.checkpw(password, u.getPassword())) {
            return true;
        }
        return false;
    }
}
