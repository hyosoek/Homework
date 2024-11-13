package com.example.board.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(UserDto userdto) {
        User user = new User();
        user.setUsername(userdto.username);
        user.setPassword(userdto.password);
        return userRepository.save(user);
    }
}
