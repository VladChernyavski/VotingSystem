package by.chernyavski.service;

import by.chernyavski.model.Role;
import by.chernyavski.model.User;
import by.chernyavski.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        user.setRoles(new HashSet<>(){{add(Role.USER);}});
        return userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getByEmail(String email){
        return userRepository.getByEmail(email);
    }

}
