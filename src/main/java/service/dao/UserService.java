package service.dao;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service(value = "userService")
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public List<User> getUsers() {
        List<User> users = userRepository.getUsers();
        return users;
    }

    public User getUserByLoginPassword(String login, String password) {
        if (login == null || password == null) return null;
        User user = userRepository.getUserByLoginPassword(login, password);
        return user;
    }

}
