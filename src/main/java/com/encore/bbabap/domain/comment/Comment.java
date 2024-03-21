package com.encore.bbabap.domain.comment;

import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt; // 삭제 시간 추가

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_tbl_id", referencedColumnName = "board_tbl_id", nullable = false)
    private Board board;

    @Builder
    public Comment(Long id, String content, LocalDateTime createdAt, LocalDateTime deletedAt, User user, Board board) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt; // 삭제 시간 설정
        this.user = user;
        this.board = board;
    }
}
