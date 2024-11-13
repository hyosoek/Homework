package com.example.board.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    long count(); // 전체 데이터 개수를 반환하는 메서드
}
