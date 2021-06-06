package md.cd.events.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import md.cd.events.models.Event;
import md.cd.events.models.User;
import md.cd.events.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        Optional<User> u = userRepository.findById(id);
        return u.isPresent() ? u.get() : null;
    }

    public User register(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        User u = findByEmail(email);
        if (u == null) {
            return false;
        }
        if (BCrypt.checkpw(password, u.getPassword())) {
            return true; 
        }
        return false;
    }

    public User joinEvent(User user, Event event) {
        List<Event> joinedEvents = user.getJoinedEvents();
        joinedEvents.add(event);
        user.setJoinedEvents(joinedEvents);
        return userRepository.save(user);
    }
    
    public User leaveEvent(User user, Event event) {
        List<Event> joinedEvents = user.getJoinedEvents();
        joinedEvents.remove(event);
        user.setJoinedEvents(joinedEvents);
        return userRepository.save(user);
    }
}
