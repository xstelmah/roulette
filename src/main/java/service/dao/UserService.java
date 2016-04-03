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

    public User getUserBySteamId(String id) {
        return userRepository.getUserBySteamId(id);
    }

    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

}
