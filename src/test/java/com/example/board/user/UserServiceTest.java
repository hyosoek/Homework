package com.example.board.user;

import com.example.board.board.Board;
import com.example.board.user.User;
import com.example.board.user.UserRepository;
import com.example.board.user.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    @Rollback
    public void setUp() {
        // 테스트용 사용자 생성
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);
    }

    @Test
    public void testGetAllUsers() {
        // 기존 사용자 조회
        List<User> allUsers = userRepository.findAll();
    }

    @Test
    @Rollback
    public void testCreateUser() {
        // 새로운 사용자 생성
        User newUser = new User();
        newUser.setUsername("newuser");
        newUser.setPassword("newpassword");

        try {
            userRepository.save(newUser);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Username already exists");
        }
        // 사용자 저장

    }

}
