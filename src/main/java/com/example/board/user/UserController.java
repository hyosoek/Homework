package com.example.board.user;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // 기본 엔트리 포인트로 변경
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping() // users에 대한 GET 요청
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping() // users에 대한 POST 요청
    public User createUser(@RequestBody UserDto userdto) {
        try {
            return userService.saveUser(userdto);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Username already exists");
        }
    }
}
