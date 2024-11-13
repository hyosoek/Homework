package com.example.board.board;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/") // 기본 엔트리 포인트로 변경
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("boards") // boards에 대한 GET 요청
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping("boards") // boards에 대한 POST 요청
    public Board createBoard(@RequestBody Board board) {
        return boardService.saveBoard(board);
    }
}

