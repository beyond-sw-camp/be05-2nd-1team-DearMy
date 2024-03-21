package com.encore.bbabap.domain.board;

import com.encore.bbabap.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_tbl_id")
    private Long id;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_yn")
    private Boolean deletedYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;


    @Builder
    public Board(Long id, String title, String content, LocalDateTime registeredAt, LocalDateTime updatedAt, Boolean deletedYn, User user) {
        this.id = id; // 롬복이 자동으로 처리
        this.title = title;
        this.content = content;
        this.registeredAt = registeredAt != null ? registeredAt : LocalDateTime.now(); // 등록 시간 설정
        this.updatedAt = updatedAt;
        this.deletedYn = deletedYn;
        if (user == null) {
            throw new IllegalArgumentException("User information is required to create a board.");
        }
        this.user = user;
    }

}
