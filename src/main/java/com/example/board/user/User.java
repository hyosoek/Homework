package com.example.board.user;

import jakarta.persistence.*;
import com.example.board.board.Board;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Setter
    private String password;

    @OneToMany(mappedBy = "user") // User는 다수의 Board를 가질 수 있음
    private List<Board> boards;

}
