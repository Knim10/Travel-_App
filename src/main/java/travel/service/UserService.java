package travel.service;

import org.springframework.beans.factory.annotation.Autowired;

import travel.beans.User;
import travel.repository.UserRepository;
import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}
