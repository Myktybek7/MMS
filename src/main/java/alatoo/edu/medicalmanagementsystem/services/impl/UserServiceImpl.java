package alatoo.edu.medicalmanagementsystem.services.impl;

import alatoo.edu.medicalmanagementsystem.entities.User;
import alatoo.edu.medicalmanagementsystem.repositories.UserRepository;
import alatoo.edu.medicalmanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
