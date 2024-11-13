package com.example.board.board;

import com.example.board.user.User;
import com.example.board.user.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    private BoardRepository boardRepository;

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
    public void testGetAllBoards() {
        List<Board> allBoards = boardRepository.findAll();
    }

    @Test
    @Rollback
    public void testCreateBoard() {
        BoardDto boardDto = new BoardDto();
        boardDto.content = "testcontent";
        boardDto.title = "testtitle";
        boardDto.user_id = 1;

        Board board = new Board();
        User user = userRepository.findById(boardDto.user_id)
                .orElseThrow(() -> new RuntimeException("User not found")); // 예외 처리
        board.setUser(user);
        board.setContent(boardDto.content);
        board.setTitle(boardDto.title);
        boardRepository.save(board);
    }
}
