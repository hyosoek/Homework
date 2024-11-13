package com.example.board.board;

import jakarta.persistence.*;
import com.example.board.user.User;
import lombok.Setter;

@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Setter
    public String title;
    @Setter
    public String content;

    @Setter
    @ManyToOne // 다수의 Board가 하나의 User에 연결됨
    @JoinColumn(name = "user_id") // 외래 키 컬럼 이름
    public User user;

}
