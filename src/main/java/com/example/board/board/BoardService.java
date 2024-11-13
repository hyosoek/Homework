package com.example.board.board;

import com.example.board.user.User;
import com.example.board.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board saveBoard(BoardDto boardDto) {
        //토큰으로부터 user의 pk값을 알아내는 부분
        Board board = new Board();
        User user = userRepository.findById(boardDto.user_id)
                .orElseThrow(() -> new RuntimeException("User not found")); // 예외 처리
        board.setUser(user);
        board.setContent(boardDto.content);
        board.setTitle(boardDto.title);
        return boardRepository.save(board);
    }
}
