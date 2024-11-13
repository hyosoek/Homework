package com.example.board.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/") // 기본 엔트리 포인트로 변경
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users") // users에 대한 GET 요청
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("users") // users에 대한 POST 요청
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
