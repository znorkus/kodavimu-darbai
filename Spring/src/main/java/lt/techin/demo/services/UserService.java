package lt.techin.demo.services;

import lt.techin.demo.models.User;
import lt.techin.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User findUserById(long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public boolean existsUserById(long id) {
        return this.userRepository.existsById(id);

    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
}

