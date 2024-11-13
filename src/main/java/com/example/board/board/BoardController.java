package com.example.board.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/") // 기본 엔트리 포인트로 변경
public class BoardController {
    private final BoardService boardService;

    @GetMapping() // boards에 대한 GET 요청
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping() // boards에 대한 POST 요청
    public Board createBoard(@RequestBody BoardDto boardDto) {
        return boardService.saveBoard(boardDto);
    }
}

