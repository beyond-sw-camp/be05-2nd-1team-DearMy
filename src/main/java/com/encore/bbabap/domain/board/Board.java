package com.encore.bbabap.domain.board;

import com.encore.bbabap.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_tbl_id")
    private Long id;

    //    @Column(name = "board_title", nullable = false, length = 255, columnDefinition = "VARCHAR(255) DEFAULT '게시글 제목을 입력하세요'")
    @Column(name = "board_title")
    private String title;

    //    @Column(name = "board_content", nullable = false, columnDefinition = "TEXT DEFAULT '게시글 내용을 입력하세요'")
    @Column(name = "board_content")
    private String content;


    @Enumerated(EnumType.STRING)
//    @Column(name = "board_delete_YN", nullable = false, columnDefinition = "ENUM('y', 'n') DEFAULT 'n'")
    @Column(name = "board_delete_YN")
    private UserStatus deleteYN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    //@JoinColumn(name = "user_id")
    private User user;
}
